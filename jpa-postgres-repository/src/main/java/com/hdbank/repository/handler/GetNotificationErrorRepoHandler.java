package com.hdbank.repository.handler;

import com.hdbank.repository.common.NotificationErrorJpaRepository;
import com.hdbank.repository.entities.NotificationErrorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GetNotificationErrorRepoHandler {
    private final NotificationErrorJpaRepository jpaRepository;

    public Optional<NotificationErrorEntity> findById(Long id) {
        return Optional.ofNullable(id)
                .flatMap(jpaRepository::findById);
    }
}
