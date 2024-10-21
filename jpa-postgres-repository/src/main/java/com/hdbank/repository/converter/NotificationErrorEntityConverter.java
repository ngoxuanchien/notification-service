package com.hdbank.repository.converter;

import com.hdbank.core.outbound.repository.model.NotificationError;
import com.hdbank.repository.entities.NotificationErrorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NotificationErrorEntityConverter {

    // TODO: Implement this method
    public NotificationErrorEntity toNotificationErrorEntity(NotificationError notificationError) {
        return NotificationErrorEntity.builder().build();

    }

    // TODO: Implement this method
    public NotificationError fromNotificationErrorEntity(NotificationErrorEntity notificationErrorEntity) {
        return NotificationError.builder().build();
    }

    // TODO: Implement this method
    public List<NotificationError> fromNotificationErrorEntities(List<NotificationErrorEntity> notificationErrorEntities) {
        return new ArrayList<>();
    }

}
