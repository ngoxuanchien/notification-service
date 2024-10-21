package com.hdbank.core.outbound.notification;

public record NotificationDetail(
        Long id,
        String notificationType,
        String notificationTitle,
        String notificationContent
) {
}
