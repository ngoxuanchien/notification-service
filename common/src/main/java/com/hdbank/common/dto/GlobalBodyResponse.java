package com.hdbank.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalBodyResponse {
    @JsonProperty("response_status")
    private ResponseStatus responseStatus;

    @JsonProperty("body_res")
    private BaseBodyResponse bodyRes;
}
