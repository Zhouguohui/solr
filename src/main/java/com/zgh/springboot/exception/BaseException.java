package com.zgh.springboot.exception;

import lombok.Data;


@Data
public class BaseException extends RuntimeException {
    private String code="";
    public BaseException(String code,String msg) {
        super(msg);
        this.setCode(code);
    }
}
