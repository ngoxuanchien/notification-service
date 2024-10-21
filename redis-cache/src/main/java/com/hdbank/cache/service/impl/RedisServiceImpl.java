package com.hdbank.cache.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdbank.cache.config.RedisAppProperties;
import com.hdbank.cache.service.RedisMapAdapter;
import com.hdbank.cache.service.RedisService;
import com.hdbank.common.util.NumberUtil;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.collections.DefaultRedisMap;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {

    private static final String ERROR_CONVERTING_MSG = "Error converting object to json";
    private static final String ERROR_PARSING_MSG = "Error parsing json to object";
    private static final String ERROR_CONNECTION_MSG = "Error connecting to redis";

    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;
    private final RedisAppProperties redisAppProperties;

    @Override
    public <T> void setValue(String key, T value) {
        try {
            var valueJson = objectMapper.writeValueAsString(value);
            redisTemplate.opsForValue()
                    .set(key, valueJson);
        } catch (JsonProcessingException e) {
            log.error(ERROR_CONVERTING_MSG, e);
        } catch (RedisConnectionFailureException e) {
            log.error(ERROR_CONNECTION_MSG, e);
        }
    }

    @Override
    public <T> void setValue(String key, T value, int expireDuration) {
        setValue(key, value);
        setExpire(key, expireDuration);
    }

    @Override
    public <T> void setValue(String key, T value, long expireDuration) {
        setValue(key, value);
        setExpire(key, expireDuration);
    }

    @Override
    public <T> T getValue(String key, Class<T> valueType) {
        try {
            var valueJson = redisTemplate.opsForValue().get(key);
            return deserialize(valueJson, valueType);
        } catch (RedisConnectionFailureException e) {
            log.error(ERROR_CONNECTION_MSG, e);
        }
        return null;
    }

    private <T> T deserialize(String valueJson, Class<T> valueType) {
        try {
            if (StringUtils.isNotEmpty(valueJson)) {
                return objectMapper.readValue(valueJson, valueType);
            }
        } catch (JsonProcessingException e) {
            log.error(ERROR_PARSING_MSG, e);
        }

        return null;
    }


    @Override
    public <T> T getAndDelete(String key, Class<T> valueType) {
        var json = redisTemplate.opsForValue().getAndDelete(key);
        return deserialize(json, valueType);
    }

    @Override
    public <T> T pollingValue(String key, Class<T> valueType) {
        return pollingValue(key, valueType, 0);
    }

    @Override
    public <T> T pollingValue(String key, Class<T> valueType, long durationMillis) {
        return pollingValue(key, valueType, durationMillis, 0);
    }

    @Override
    @SneakyThrows
    public <T> T pollingValue(String key, Class<T> valueType, long durationMillis, long intervalMillis) {
        long effectiveDuration = getOrDefaultDurationMillis(durationMillis);
        long effectiveInterval = getOrDefaultPollingIntervalMillis(intervalMillis);
        long endTime = System.currentTimeMillis() + effectiveDuration;

        while (System.currentTimeMillis() < endTime) {
            Optional<T> result = Optional.ofNullable(getAndDelete(key, valueType));
            if (result.isPresent()) {
                return result.get();
            }

            Thread.sleep(effectiveInterval);
        }
        return null;
    }

    private long getOrDefaultPollingIntervalMillis(long intervalMillis) {
        return NumberUtil.greaterThanZero(intervalMillis)
                ? intervalMillis
                : redisAppProperties.getDefaultPollingInterval();
    }

    private long getOrDefaultDurationMillis(long durationMillis) {
        return NumberUtil.greaterThanZero(durationMillis)
                ? durationMillis
                : redisAppProperties.getDefaultPollingDuration();
    }

    private long getOrDefaultExpiredTimeInSecond(long expireDuration) {
        return NumberUtil.greaterThanZero(expireDuration)
                ? expireDuration
                : redisAppProperties.getDefaultExpiredTimeInSecond();
    }

    @Override
    public void deleteByKey(String key) {
        try {
            redisTemplate.delete(key);
        } catch (RedisConnectionFailureException e) {
            log.error(ERROR_CONNECTION_MSG, e);
        }
    }

    @Override
    public void setExpire(String key, int expireDuration) {
        try {
            long expireDurationMillis = getOrDefaultExpiredTimeInSecond(expireDuration);
            redisTemplate.expire(key, expireDurationMillis, TimeUnit.SECONDS);
        } catch (RedisConnectionFailureException e) {
            log.error(ERROR_CONNECTION_MSG, e);
        }
    }

    @Override
    public void setExpire(String key, long expireDuration) {
        try {
            long expireDurationMillis = getOrDefaultExpiredTimeInSecond(expireDuration);
            redisTemplate.expire(key, expireDurationMillis, TimeUnit.SECONDS);
        } catch (RedisConnectionFailureException e) {
            log.error(ERROR_CONNECTION_MSG, e);
        }
    }

    @Override
    public <K, V> RedisMapAdapter<K, V> forMap(String key, Class<K> keyType, Class<V> valueType) {
        return new RedisMapAdapterImpl<>(new DefaultRedisMap<>(redisTemplate.boundHashOps(key)));
    }
}
