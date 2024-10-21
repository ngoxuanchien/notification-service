package com.hdbank.core.domain.mapping;

import com.hdbank.common.annotation.Application;
import com.hdbank.core.dto.notification.request.NotificationErrorEvent;
import com.hdbank.core.outbound.repository.model.NotificationError;

@Application
public class NotificationErrorEventMapping {
    public NotificationError toNotificationError(NotificationErrorEvent notificationErrorEvent) {
        return NotificationError.builder()
                .eventId(notificationErrorEvent.eventId())
                .notificationType(notificationErrorEvent.notificationType())
                .notificationDetails(notificationErrorEvent.notificationDetails())
                .resourceType(notificationErrorEvent.resourceType())
                .serviceName(notificationErrorEvent.serviceName())
                .status(notificationErrorEvent.status())
                .valueTimestamp(notificationErrorEvent.valueTimestamp())
                .isRollback(Boolean.parseBoolean(notificationErrorEvent.isRollback().toLowerCase()))
                .resourceId(notificationErrorEvent.resourceId())
                .build();
    }
}
