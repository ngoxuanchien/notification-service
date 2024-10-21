package com.hdbank.common.log.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdbank.common.annotation.Application;
import lombok.RequiredArgsConstructor;

@Application
@RequiredArgsConstructor
public class JsonUtil {
    private final ObjectMapper objectMapper;

    public <T> String convertToJson(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String serialize(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return object.toString();
        }
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error converting Json to object", e);
        }
    }

    public JsonNode fromJson(String json) {
        try {
            return objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error converting Json to object", e);
        }
    }
}
