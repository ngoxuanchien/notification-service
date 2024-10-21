package com.hdbank.common.log.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEntity {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final Map<String, Object> attributes = new HashMap<>();

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "to_json_error: " + e.getMessage();
        }
    }

    public Object addAttribute(String key, Object value) {
        return attributes.put(key, value);
    }
}
