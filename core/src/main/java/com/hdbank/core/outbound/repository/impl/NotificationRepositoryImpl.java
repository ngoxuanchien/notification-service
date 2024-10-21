package com.hdbank.core.outbound.repository.impl;

import com.hdbank.core.outbound.repository.NotificationErrorRepository;
import com.hdbank.core.outbound.repository.model.NotificationError;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationErrorRepository {

    private final Map<Long, NotificationError> notificationErrorMap = new HashMap<>();

    @Override
    public Optional<NotificationError> save(NotificationError notificationError) {
        return Optional.ofNullable(notificationError)
                .map(notification -> {
                    notificationErrorMap.put(notification.getId(), notification);
                    return notification;
                });

    }

    @Override
    public Optional<NotificationError> findById(Long id) {
        return Optional.of(notificationErrorMap.get(id));
    }
}
