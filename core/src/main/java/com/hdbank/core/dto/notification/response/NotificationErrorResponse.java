package com.hdbank.core.dto.notification.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record NotificationErrorResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("event_id") UUID eventId,
        @JsonProperty("notification_type") String notificationType,
        @JsonProperty("resource_id") String resourceId,
        @JsonProperty("resource_type") String resourceType,
        @JsonProperty("notification_details") String notificationDetails,
        @JsonProperty("status") String status,
        @JsonProperty("service_name") String serviceName,
        @JsonProperty("is_rollback") boolean isRollback,
        @JsonProperty("value_timestamp") String valueTimestamp,
        @JsonProperty("processed") boolean processed
) {
}
