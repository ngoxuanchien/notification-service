package com.hdbank.core.api;

import com.hdbank.core.dto.notification.response.NotificationErrorResponse;

public interface NotificationErrorApi {

    void handleNotificationError(String notificationErrorEvent);

    NotificationErrorResponse getById(Long id);

}
