package com.example.monolithic.exception.writer;

import com.example.monolithic.exception.ErrorCode;
import lombok.Getter;

@Getter
public class WriterException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String errorMessage;

    public WriterException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getErrorMessage();
    }
}
