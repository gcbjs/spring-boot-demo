package com.yzb.springboot.exception;

import lombok.Data;

/**
 * Create by yuzhangbin on 2018/1/9
 */
@Data
public class ErrorInfo<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 500;

    private Integer code;

    private String message;

    private String url;

    private T data;

}
