package com.hdbank.common.log.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class RootEntity extends BaseEntity {

    @JsonProperty("app_id_def")
    public static String appIdDef;

    @JsonProperty("app_id")
    public static String appNameDef;

    @JsonProperty("event_type")
    private String eventType;

    @JsonProperty("detail_event")
    private String detailEvent;

    @JsonProperty("request")
    private RequestEntity request;

    @JsonProperty("detail")
    private LogEntity detail;

    private long start;

    @JsonProperty("exp_stacks")
    private String expStacks;

    @JsonIgnore
    public transient Throwable exp;

    public RootEntity() {
        super();
        this.start = System.currentTimeMillis();
    }

    public static RootEntity create() {
        return new RootEntity();
    }

    public RootEntity type(String eventType) {
        this.eventType = eventType;
        return this;
    }

    private RequestEntity req(boolean force) {
        if (request == null && force) {
            request = new RequestEntity();
        }

        return request;
    }

    public RootEntity reqAttribute(String key, Object value) {
        req(true).addAttribute(key, value);
        return this;
    }

    private LogEntity detail(boolean force) {
        if (detail == null && force) {
            detail = new LogEntity();
        }

        return detail;
    }

    public RootEntity success() {
        detail(true).resultStatus("success");
        return this;
    }

    private RootEntity detailResultStatus(String status) {
        detail(true).resultStatus(status);
        return this;
    }

    public RootEntity exp(Throwable exp) {
        this.exp = exp;
        expStacks += Arrays.toString(exp.getStackTrace()) + "\n";
        return detailResultStatus("error: " + exp.getMessage());
    }

    public RootEntity fail() {
        detail(true).resultStatus("failed");
        return this;
    }

    public void elapsed() {
        long elapsed = System.currentTimeMillis() - start;
        detail(true).getResult(true).setElapsed(elapsed);
    }

    public RootEntity reqId(String id) {
        req(true).setId(id);
        return this;
    }

    public RootEntity success(String entity) {
        detail(true).resultStatus("success").resultEntity(entity);
        return this;
    }
}
