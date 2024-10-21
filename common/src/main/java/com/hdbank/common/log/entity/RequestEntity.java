package com.hdbank.common.log.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.Date;

@Setter
public class RequestEntity extends BaseEntity {

    private String id;

    private String sid;

    private String user;

    @JsonProperty("service_name")
    private String serviceName;

    private String uri;

    private String time = new Date().toString();
}
