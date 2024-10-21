package com.hdbank.core.domain.service;

import com.hdbank.core.domain.mapping.NotificationErrorResponseMapping;
import com.hdbank.core.outbound.cache.NotificationErrorCache;
import com.hdbank.core.outbound.cache.impl.NotificationErrorCacheImpl;
import com.hdbank.core.outbound.repository.NotificationErrorRepository;
import com.hdbank.core.outbound.repository.impl.NotificationRepositoryImpl;
import com.hdbank.core.outbound.repository.model.NotificationError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class NotificationErrorServiceImplTest {

    private static NotificationErrorRepository notificationErrorRepository;

    private static NotificationErrorService notificationErrorService;

    private static NotificationErrorResponseMapping notificationErrorResponseMapping;

    private static NotificationErrorCache notificationErrorCache;

    @BeforeAll
    static void beforeAll() {
        notificationErrorRepository = new NotificationRepositoryImpl();
        notificationErrorResponseMapping = new NotificationErrorResponseMapping();
        notificationErrorCache = new NotificationErrorCacheImpl();
        notificationErrorService = new NotificationErrorServiceImpl(
                notificationErrorRepository,
                notificationErrorResponseMapping,
                notificationErrorCache
        );
    }

//    @Test
//    void save() {
//        var notificationError = new NotificationError();
//        when(notificationErrorRepository.save(notificationError))
//                .thenReturn(Optional.of(notificationError));
//
//        notificationErrorService.save(notificationError);
//    }

    @Test
    void findById() {
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


        var notificationErrorResponse = notificationErrorResponseMapping.fromNotificationError(notificationError);
        notificationErrorService.save(notificationError);

        var result = notificationErrorService.findById(1L);
        Assertions.assertEquals(result, notificationErrorResponse);
    }
}