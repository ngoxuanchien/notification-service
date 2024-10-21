package com.hdbank.cache;

import com.hdbank.cache.handler.GetNotificationCacheHandler;
import com.hdbank.cache.handler.SetNotificationCacheHandler;
import com.hdbank.core.outbound.cache.NotificationErrorCache;
import com.hdbank.core.outbound.repository.model.NotificationError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NotificationErrorCacheImpl implements NotificationErrorCache {

    private final GetNotificationCacheHandler getNotificationCacheHandler;
    private final SetNotificationCacheHandler setNotificationCacheHandler;


    @Override
    public Optional<NotificationError> getNotificationError(Long id) {
        return Optional.ofNullable(getNotificationCacheHandler.getNotificationError(id.toString()));
    }

    @Override
    public void set(String key, NotificationError value) {
        setNotificationCacheHandler.set(key, value);
    }
}
