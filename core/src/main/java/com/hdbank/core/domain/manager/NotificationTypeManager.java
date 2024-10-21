package com.hdbank.core.domain.manager;

import com.hdbank.core.dto.notification.request.NotificationErrorEvent;

public interface NotificationTypeManager {
    void handleEvent(String notificationType, NotificationErrorEvent notificationErrorEvent);
}
