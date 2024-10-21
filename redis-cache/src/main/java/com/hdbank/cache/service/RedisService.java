package com.hdbank.cache.service;

public interface RedisService {

    <T> void setValue(final String key, T value);


    <T> void setValue(final String key, T value, int expireDuration);

    <T> void setValue(final String key, T value, long expireDuration);

    <T> T getValue(final String key, Class<T> valueType);

    <T> T getAndDelete(final String key, Class<T> valueType);

    <T> T pollingValue(final String key, Class<T> valueType);

    <T> T pollingValue(final String key, Class<T> valueType, long durationMillis);

    <T> T pollingValue(final String key, Class<T> valueType, long durationMillis, long intervalMillis);

    void deleteByKey(final String key);

    void setExpire(final String key, int expireDuration);

    void setExpire(final String key, long expireDuration);

    <K, V> RedisMapAdapter<K, V> forMap(final String key, Class<K> keyType, Class<V> valueType);
}
