package com.hdbank.core.outbound.cache;

import com.hdbank.core.outbound.repository.model.NotificationError;

import java.util.Optional;

public interface NotificationErrorCache {

    Optional<NotificationError> getNotificationError(Long id);

    void set(String key, NotificationError value);
}
