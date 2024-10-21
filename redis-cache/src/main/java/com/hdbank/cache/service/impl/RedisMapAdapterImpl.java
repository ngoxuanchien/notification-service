package com.hdbank.cache.service.impl;

import com.hdbank.cache.service.RedisMapAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.support.collections.RedisMap;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class RedisMapAdapterImpl<K, V> implements RedisMapAdapter<K, V> {

    private final RedisMap<K, V> redisMap;

    @Override
    public ConcurrentMap<K, V> getMap() {
        return redisMap;
    }

    @Override
    public boolean expire(long timeout, TimeUnit unit) {
        var result = redisMap.expire(timeout, unit);
        return Boolean.TRUE.equals(result);
    }

    @Override
    public boolean expire(Duration duration) {
        var result = redisMap.expire(duration);
        return Boolean.TRUE.equals(result);
    }

    @Override
    public boolean expireAt(Instant instant) {
        var result = redisMap.expireAt(instant);
        return Boolean.TRUE.equals(result);
    }

    @Override
    public boolean expireAt(Date date) {
        var result = redisMap.expireAt(date);
        return Boolean.TRUE.equals(result);
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return redisMap.entrySet();
    }
}
