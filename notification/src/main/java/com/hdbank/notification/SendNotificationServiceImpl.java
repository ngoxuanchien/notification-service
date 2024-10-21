package com.hdbank.notification;

import com.hdbank.core.outbound.notification.NotificationDetail;
import com.hdbank.core.outbound.notification.SendNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendNotificationServiceImpl implements SendNotificationService {

    private final ApplicationEventPublisher publisher;

    @Override
    public void notify(NotificationDetail notification) {
        publisher.publishEvent(notification);
    }
}
