package com.hdbank.core.domain.manager.impl;

import com.hdbank.common.annotation.Application;
import com.hdbank.core.dto.notification.request.NotificationErrorEvent;
import com.hdbank.core.domain.handler.NotificationTypeHandler;
import com.hdbank.core.domain.manager.NotificationTypeManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Application
public class NotificationTypeManagerImpl implements NotificationTypeManager {

    private final Map<String, NotificationTypeHandler> notificationTypeHandlerMap = new HashMap<>();

    public NotificationTypeManagerImpl(List<NotificationTypeHandler> notificationTypeHandlers) {
        notificationTypeHandlers.forEach(handler -> notificationTypeHandlerMap.put(handler.getNotificationType(), handler));
    }

    @Override
    public void handleEvent(String notificationType, NotificationErrorEvent notificationErrorEvent) {
        Optional.ofNullable(notificationTypeHandlerMap.get(notificationType))
                .ifPresent(handler -> handler.handleEvent(notificationErrorEvent));
    }
}
