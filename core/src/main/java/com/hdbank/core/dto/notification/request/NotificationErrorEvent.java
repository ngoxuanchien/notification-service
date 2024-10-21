package com.hdbank.core.dto.notification.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record NotificationErrorEvent(
        @JsonProperty("event_id") UUID eventId,
        @JsonProperty("notification_type") String notificationType,
        @JsonProperty("resource_id") String resourceId,
        @JsonProperty("resource_type") String resourceType,
        @JsonProperty("notification_details") String notificationDetails,
        @JsonProperty("status") String status,
        @JsonProperty("service_name") String serviceName,
        @JsonProperty("is_rollback") String isRollback,
        @JsonProperty("value_timestamp") String valueTimestamp
) {

}
