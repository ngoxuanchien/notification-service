package com.hdbank.core.domain.service;

import com.hdbank.common.annotation.Application;
import com.hdbank.core.domain.exception.NotificationNotFoundException;
import com.hdbank.core.domain.mapping.NotificationErrorResponseMapping;
import com.hdbank.core.dto.notification.response.NotificationErrorResponse;
import com.hdbank.core.outbound.cache.NotificationErrorCache;
import com.hdbank.core.outbound.repository.NotificationErrorRepository;
import com.hdbank.core.outbound.repository.model.NotificationError;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Application
@RequiredArgsConstructor
public class NotificationErrorServiceImpl implements NotificationErrorService {

    private final NotificationErrorRepository repository;

    private final NotificationErrorResponseMapping notificationErrorResponseMapping;

    private final NotificationErrorCache notificationErrorCache;

    @Override
    public NotificationError save(NotificationError notificationError) {
        return Optional.ofNullable(notificationError)
                .flatMap(repository::save)
                .orElseThrow(() -> new RuntimeException("Failed to save notification error"));
    }

    @Override
    public NotificationErrorResponse findById(Long id) {
        return Optional.ofNullable(id)
                .flatMap(notificationErrorCache::getNotificationError)
                .or(() -> repository.findById(id))
                .map(notificationErrorResponseMapping::fromNotificationError)
                .orElseThrow(() -> new NotificationNotFoundException("Notification error not found"));
    }
}
