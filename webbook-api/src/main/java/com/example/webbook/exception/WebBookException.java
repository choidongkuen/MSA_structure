package com.example.webbook.exception;

import lombok.Getter;

@Getter
public class WebBookException extends RuntimeException {

    private final ErrorCode errorCode;

    public WebBookException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
