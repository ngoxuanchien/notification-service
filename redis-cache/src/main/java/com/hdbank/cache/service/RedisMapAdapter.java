package com.hdbank.cache.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public interface RedisMapAdapter<K, V> {

    ConcurrentMap<K, V> getMap();

    boolean expire(long timeout, TimeUnit unit);

    boolean expire(Duration duration);

    boolean expireAt(Instant instant);

    boolean expireAt(Date date);

    Set<Map.Entry<K, V>> entrySet();
}
