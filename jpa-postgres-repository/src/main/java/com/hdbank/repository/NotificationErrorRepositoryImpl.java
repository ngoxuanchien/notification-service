package com.hdbank.repository;

import com.hdbank.core.outbound.repository.NotificationErrorRepository;
import com.hdbank.core.outbound.repository.model.NotificationError;
import com.hdbank.repository.converter.NotificationErrorEntityConverter;
import com.hdbank.repository.handler.CreateNotificationErrorRepoHandler;
import com.hdbank.repository.handler.GetNotificationErrorRepoHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class NotificationErrorRepositoryImpl implements NotificationErrorRepository {

    private final CreateNotificationErrorRepoHandler createNotificationErrorRepoHandler;

    private final NotificationErrorEntityConverter notificationErrorEntityConverter;

    private final GetNotificationErrorRepoHandler getNotificationErrorRepoHandler;

    @Override
    public Optional<NotificationError> save(NotificationError notificationError) {
        log.info("Save the notification error: NotificationError={}", notificationError);
        return Optional.ofNullable(notificationError)
                .map(notificationErrorEntityConverter::toNotificationErrorEntity)
                .map(createNotificationErrorRepoHandler::save)
                .map(notificationErrorEntityConverter::fromNotificationErrorEntity);
    }

    @Override
    public Optional<NotificationError> findById(Long id) {
        log.info("Find the notification error by id: id={}", id);
        return Optional.ofNullable(id)
                .flatMap(getNotificationErrorRepoHandler::findById)
                .map(notificationErrorEntityConverter::fromNotificationErrorEntity);
    }
}
