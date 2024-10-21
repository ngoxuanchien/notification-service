package com.hdbank.core.domain.mapping;

import com.hdbank.common.annotation.Application;
import com.hdbank.core.dto.notification.response.NotificationErrorResponse;
import com.hdbank.core.outbound.repository.model.NotificationError;

@Application
public class NotificationErrorResponseMapping {

    public NotificationErrorResponse fromNotificationError(NotificationError notificationError) {
        return new NotificationErrorResponse(
                notificationError.getId(),
                notificationError.getEventId(),
                notificationError.getNotificationType(),
                notificationError.getResourceId(),
                notificationError.getResourceType(),
                notificationError.getNotificationDetails(),
                notificationError.getStatus(),
                notificationError.getServiceName(),
                notificationError.isRollback(),
                notificationError.getValueTimestamp(),
                notificationError.isProcessed()
        );
    }
}
