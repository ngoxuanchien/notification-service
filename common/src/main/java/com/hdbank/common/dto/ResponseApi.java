package com.hdbank.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseApi<T> {
    private Integer status;

    private T data;

    public ResponseApi(Integer status) {
        this.status = status;
    }

    public static <T> ResponseApi<T> success(T data) {
        return new ResponseApi<>(200, data);
    }

    public static <T> ResponseApi<T> error(Integer status) {
        return new ResponseApi<>(status);
    }
}
