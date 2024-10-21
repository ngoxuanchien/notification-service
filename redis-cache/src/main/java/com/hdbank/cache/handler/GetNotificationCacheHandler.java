package com.hdbank.cache.handler;

import com.hdbank.cache.service.RedisService;
import com.hdbank.core.outbound.repository.model.NotificationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GetNotificationCacheHandler {
    private final RedisService redisService;

    public NotificationError getNotificationError(String id) {
        return redisService.getValue(id, NotificationError.class);
    }
}
