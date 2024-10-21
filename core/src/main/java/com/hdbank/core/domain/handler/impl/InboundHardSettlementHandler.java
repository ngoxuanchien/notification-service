package com.hdbank.core.domain.handler.impl;

import com.hdbank.common.annotation.Application;
import com.hdbank.core.dto.notification.request.NotificationErrorEvent;
import com.hdbank.core.domain.constant.NotificationTypeConstant;
import com.hdbank.core.domain.handler.NotificationTypeHandler;
import com.hdbank.core.domain.mapping.NotificationDetailMapping;
import com.hdbank.core.domain.mapping.NotificationErrorEventMapping;
import com.hdbank.core.domain.service.NotificationErrorServiceImpl;
import com.hdbank.core.outbound.notification.SendNotificationService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Application
@RequiredArgsConstructor
public class InboundHardSettlementHandler implements NotificationTypeHandler {

    private final NotificationErrorServiceImpl notificationErrorService;

    private final SendNotificationService notifyManager;

    private final NotificationErrorEventMapping notificationErrorEventMapping;

    private final NotificationDetailMapping notificationDetailMapping;

    @Override
    public void handleEvent(NotificationErrorEvent event) {
        Optional.ofNullable(event)
                .map(notificationErrorEventMapping::toNotificationError)
                .map(notificationErrorService::save)
                .map(notificationDetailMapping::fromNotificationError)
                .ifPresent(notifyManager::notify);
    }

    @Override
    public String getNotificationType() {
        return NotificationTypeConstant.INBOUND_HARD_SETTLEMENT;
    }
}
