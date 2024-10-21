package com.hdbank.controller.mapping.exception;

import com.hdbank.common.dto.ResponseApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ExceptionManagerMapper {

    private static final Map<Class<?>, IExceptionMapper<?>> mapperExceptions = new HashMap<>();

    public void putMapperException(Class<?> clazz, IExceptionMapper<?> mapper) {
        mapperExceptions.put(clazz, mapper);
    }

    public <T>ResponseEntity<ResponseApi<?>> castExceptionToResponse(T request) {
        return getMapperException(request.getClass())
                .map(validator -> (IExceptionMapper<T>) validator)
                .map(validator -> validator.castException(request))
                .orElse(ResponseEntity.badRequest().build());
    }

    public <T>Optional<IExceptionMapper<T>> getMapperException(Class<T> clazz) {
        return Optional.ofNullable((IExceptionMapper<T>) mapperExceptions.get(clazz));
    }
}
