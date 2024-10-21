package com.hdbank.core.api.impl;

import com.hdbank.common.annotation.Application;
import com.hdbank.common.log.utils.JsonUtil;
import com.hdbank.core.api.NotificationErrorApi;
import com.hdbank.core.dto.notification.request.NotificationErrorEvent;
import com.hdbank.core.dto.notification.response.NotificationErrorResponse;
import com.hdbank.core.domain.manager.ResourceTypeManager;
import com.hdbank.core.domain.service.NotificationErrorServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Application
@RequiredArgsConstructor
public class NotificationErrorApiImpl implements NotificationErrorApi {

    private final NotificationErrorServiceImpl notificationErrorService;

    private final ResourceTypeManager resourceTypeManager;

    private final JsonUtil jsonUtil;

    @Override
    public void handleNotificationError(String notificationErrorEvent) {
        Optional.ofNullable(notificationErrorEvent)
                .map(json -> jsonUtil.fromJson(notificationErrorEvent, NotificationErrorEvent.class))
                .ifPresent(event -> resourceTypeManager.handleEvent(event.resourceType(), event));
    }

    @Override
    public NotificationErrorResponse getById(Long id) {
        return Optional.ofNullable(id)
                .map(notificationErrorService::findById)
                .orElseThrow();
    }
}
