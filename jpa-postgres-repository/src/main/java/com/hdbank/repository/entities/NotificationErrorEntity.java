package com.hdbank.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "notification_error")
public class NotificationErrorEntity {

    @Id
    private Long id;

    @Column(name = "event_id")
    private String eventId;

    @Column(name = "notification_type")
    private String notificationType;

    @Column(name = "resource_id")
    private String resourceId;

    @Column(name = "resource_type")
    private String resourceType;

    @Column(name = "notification_details")
    private String notificationDetails;

    @Column(name = "status")
    private String status;

    @Column(name = "is_rollback")
    private boolean isRollback;

    @Column(name = "value_timestamp")
    private String valueTimestamp;

    private boolean processed;

    @CreatedDate
    private String createdDate;
}
