package com.hdbank.core.domain.exception;

public class NotificationNotFoundException extends RuntimeException {
    public NotificationNotFoundException(String message) {
        super(message);
    }
}
