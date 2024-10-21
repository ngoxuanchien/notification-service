package com.hdbank.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatus {
    @JsonProperty("request_id")
    private String requestId;

    private String status;

    private String code;

    private List<String> description;
}
