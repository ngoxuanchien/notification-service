package com.hdbank.common.log.entity;

import lombok.Getter;

@Getter
public class LogEntity extends BaseEntity {
    private ResultEntity result;

    private ResultEntity rs(boolean force) {
        if (result == null || force) {
            result = new ResultEntity();
        }

        return result;
    }

    public LogEntity resultStatus(String status) {
        rs(true).setStatus(status);
        return this;
    }

    public ResultEntity getResult(boolean force) {
        return rs(force);
    }

    public LogEntity resultEntity(String entity) {
        rs(true).setEntity(entity);
        return this;
    }
}
