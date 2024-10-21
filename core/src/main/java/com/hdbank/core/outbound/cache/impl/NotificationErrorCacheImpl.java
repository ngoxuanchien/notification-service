package com.hdbank.core.outbound.cache.impl;

import com.hdbank.core.outbound.cache.NotificationErrorCache;
import com.hdbank.core.outbound.repository.model.NotificationError;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class NotificationErrorCacheImpl implements NotificationErrorCache {


    @Override
    public Optional<NotificationError> getNotificationError(Long id) {
        // do nothing
        return Optional.empty();
    }

    @Override
    public void set(String key, NotificationError value) {
        // do nothing
    }
}
