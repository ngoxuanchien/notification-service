package com.hdbank.core.domain.manager;

import com.hdbank.core.dto.notification.request.NotificationErrorEvent;

public interface ResourceTypeManager {
    void handleEvent(String resourceType, NotificationErrorEvent notificationErrorEvent);
}
