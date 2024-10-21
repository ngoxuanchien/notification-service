package com.hdbank.controller.notification;

import com.hdbank.core.api.NotificationErrorApi;
import com.hdbank.core.dto.notification.response.NotificationErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification-error")
@RequiredArgsConstructor
@Slf4j
public class NotificationErrorController {

    private final NotificationErrorApi notificationErrorApi;

    @GetMapping("/{id}")
    public ResponseEntity<NotificationErrorResponse> getNotificationError(@PathVariable("id") Long id) {
        return ResponseEntity.ok(notificationErrorApi.getById(id));
    }
}
