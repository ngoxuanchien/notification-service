package com.hdbank.core.outbound.repository.impl;

import com.hdbank.core.outbound.repository.NotificationErrorRepository;
import com.hdbank.core.outbound.repository.model.NotificationError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class NotificationRepositoryImplTest {

    private static NotificationErrorRepository notificationErrorRepository;

    @BeforeAll
    static void beforeAll() {
        notificationErrorRepository = new NotificationRepositoryImpl();
    }

    @Test
    void save() {
        var notificationError = NotificationError.builder()
                .id(1L)
                .eventId(UUID.randomUUID())
                .notificationType("error")
                .notificationDetails("error")
                .resourceId("error")
                .resourceType("error")
                .status("error")
                .serviceName("error")
                .isRollback(true)
                .valueTimestamp("error")
                .processed(true)
                .build();

        var result = notificationErrorRepository.save(notificationError);
        Assertions.assertNotNull(result);
    }
}