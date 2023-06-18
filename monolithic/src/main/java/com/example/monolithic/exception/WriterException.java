package com.example.monolithic.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WriterException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String errorMessage;

    public WriterException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getErrorMessage();
    }
}
