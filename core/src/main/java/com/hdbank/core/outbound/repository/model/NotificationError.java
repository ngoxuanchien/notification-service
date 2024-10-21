package com.hdbank.core.outbound.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationError {
    private Long id;
    private UUID eventId;
    private String notificationType;
    private String resourceId;
    private String resourceType;
    private String notificationDetails;
    private String status;
    private String serviceName;
    private boolean isRollback;
    private String valueTimestamp;
    private boolean processed;
}
