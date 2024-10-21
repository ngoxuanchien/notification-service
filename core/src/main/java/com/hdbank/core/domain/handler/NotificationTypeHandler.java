package com.hdbank.core.domain.handler;

import com.hdbank.core.dto.notification.request.NotificationErrorEvent;

public interface NotificationTypeHandler {

    void handleEvent(NotificationErrorEvent event);

    String getNotificationType();
}
