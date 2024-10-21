package com.hdbank.core.domain.service;

import com.hdbank.core.dto.notification.response.NotificationErrorResponse;
import com.hdbank.core.outbound.repository.model.NotificationError;

public interface NotificationErrorService {
    NotificationError save(NotificationError notificationError);

    NotificationErrorResponse findById(Long id);
}
