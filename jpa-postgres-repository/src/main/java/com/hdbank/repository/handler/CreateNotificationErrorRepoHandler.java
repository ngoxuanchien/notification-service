package com.hdbank.repository.handler;

import com.hdbank.repository.common.NotificationErrorJpaRepository;
import com.hdbank.repository.entities.NotificationErrorEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Slf4j
public class CreateNotificationErrorRepoHandler {

    private final NotificationErrorJpaRepository jpaRepository;

    public NotificationErrorEntity save(NotificationErrorEntity entity) {
        log.info("Saving notification error entity: {}", entity);
        return Optional.ofNullable(entity)
                .map(jpaRepository::save)
                .orElse(null);
    }
}
