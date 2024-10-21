package com.hdbank.consumer.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;

@Slf4j
@AllArgsConstructor
public abstract class AbstractEventConsumer {
    protected void handleSuccess(ConsumerRecord<String, String> event) {
        log.info("Processed event: Headers={}", event.headers());
    }

    protected void handleFailure(Throwable error, ConsumerRecord<String, String> event) {
        log.error("Error in processing event: Error={}, Headers={}, Message={}",
                error.getMessage(),
                event.headers(),
                event.value()
        );
    }
}
