package com.hdbank.repository.common;

import com.hdbank.repository.entities.NotificationErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationErrorJpaRepository extends JpaRepository<NotificationErrorEntity, Long> {
}
