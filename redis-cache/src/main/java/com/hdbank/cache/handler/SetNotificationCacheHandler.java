package com.hdbank.cache.handler;

import com.hdbank.cache.service.RedisService;
import com.hdbank.core.outbound.repository.model.NotificationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SetNotificationCacheHandler {

    private final RedisService redisService;

    public void set(String key, NotificationError value) {
        redisService.setValue(key, value);
    }
}
