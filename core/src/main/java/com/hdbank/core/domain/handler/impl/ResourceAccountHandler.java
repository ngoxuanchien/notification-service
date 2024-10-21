package com.hdbank.core.domain.handler.impl;

import com.hdbank.core.dto.notification.request.NotificationErrorEvent;
import com.hdbank.core.domain.constant.ResourceTypeConstant;
import com.hdbank.core.domain.handler.ResourceTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResourceAccountHandler implements ResourceTypeHandler {

    @Override
    public void handleEvent(NotificationErrorEvent notificationErrorEvent) {
        System.out.println("Handling event for account resource");
        // do nothing
    }

    @Override
    public String getResourceType() {
        return ResourceTypeConstant.RESOURCE_ACCOUNT;
    }
}
