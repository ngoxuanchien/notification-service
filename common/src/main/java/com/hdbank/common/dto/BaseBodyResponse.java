package com.hdbank.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseBodyResponse {

    @JsonProperty("tran_seq_no")
    private String tranSeqNo;

    @JsonProperty("value_timestamp")
    private String valueTimestamp;

    @JsonProperty("request_id")
    private String requestId;

}
