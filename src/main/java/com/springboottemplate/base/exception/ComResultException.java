package com.springboottemplate.base.exception;

import lombok.Data;

@Data
public class ComResultException extends RuntimeException {

    private String code;
    private String message;

    public ComResultException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}