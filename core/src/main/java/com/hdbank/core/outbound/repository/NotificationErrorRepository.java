package com.hdbank.core.outbound.repository;

import com.hdbank.core.outbound.repository.model.NotificationError;

import java.util.Optional;

public interface NotificationErrorRepository {
    Optional<NotificationError> save(NotificationError notificationError);

    Optional<NotificationError> findById(Long id);
}
