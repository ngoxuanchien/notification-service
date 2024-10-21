package com.hdbank.core.domain.handler.impl;

import com.hdbank.common.annotation.Application;
import com.hdbank.core.dto.notification.request.NotificationErrorEvent;
import com.hdbank.core.domain.constant.ResourceTypeConstant;
import com.hdbank.core.domain.handler.ResourceTypeHandler;
import com.hdbank.core.domain.manager.NotificationTypeManager;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Application
@RequiredArgsConstructor
public class PostingAccountHandler implements ResourceTypeHandler {

    private final NotificationTypeManager notificationTypeManager;

    @Override
    public void handleEvent(NotificationErrorEvent notificationErrorEvent) {
        Optional.ofNullable(notificationErrorEvent)
                .ifPresent(event -> notificationTypeManager.handleEvent(event.notificationType(), event));
    }

    @Override
    public String getResourceType() {
        return ResourceTypeConstant.POSTING_ACCOUNT;
    }
}
