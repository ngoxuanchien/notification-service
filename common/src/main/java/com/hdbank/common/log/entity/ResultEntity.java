package com.hdbank.common.log.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultEntity extends BaseEntity {

    private String id;

    private String status = "failed";

    private Object entity;

    private long elapsed;
}
