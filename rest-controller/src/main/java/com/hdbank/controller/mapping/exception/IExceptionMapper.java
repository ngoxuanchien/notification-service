package com.hdbank.controller.mapping.exception;

import com.hdbank.common.dto.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface IExceptionMapper<T> {
    ResponseEntity<ResponseApi<?>> castException(T exception);
}
