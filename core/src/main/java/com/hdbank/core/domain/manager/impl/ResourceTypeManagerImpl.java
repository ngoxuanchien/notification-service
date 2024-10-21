package com.hdbank.core.domain.manager.impl;

import com.hdbank.common.annotation.Application;
import com.hdbank.core.dto.notification.request.NotificationErrorEvent;
import com.hdbank.core.domain.handler.ResourceTypeHandler;
import com.hdbank.core.domain.manager.ResourceTypeManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Application
public class ResourceTypeManagerImpl implements ResourceTypeManager {

    private final Map<String, ResourceTypeHandler> notificationTypeHandlerMap = new HashMap<>();

    public ResourceTypeManagerImpl(List<ResourceTypeHandler> notificationTypeHandlers) {
        notificationTypeHandlers.forEach(handler -> notificationTypeHandlerMap.put(handler.getResourceType(), handler));
    }

    @Override
    public void handleEvent(String resourceType, NotificationErrorEvent notificationErrorEvent) {
        Optional.ofNullable(notificationTypeHandlerMap.get(resourceType))
                .ifPresent(handler -> handler.handleEvent(notificationErrorEvent));
    }
}
