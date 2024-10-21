package com.hdbank.consumer.notification;

import com.hdbank.core.api.NotificationErrorApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationConsumer extends AbstractEventConsumer {

    private final NotificationErrorApi notificationErrorApi;

    @KafkaListener(
            topics = "#{notificationKafka.getTopic()}",
            groupId = "#{notificationKafka.getGroupId()}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(ConsumerRecord<String, String> event) {
        log.info("Consuming message: {}", event.value());
        try {
            if (true) {
                throw new RuntimeException("Error");
            }
            notificationErrorApi.handleNotificationError(event.value());
            handleSuccess(event);

        } catch (Exception e) {
            handleFailure(e, event);
            throw e;
        }
    }
}
