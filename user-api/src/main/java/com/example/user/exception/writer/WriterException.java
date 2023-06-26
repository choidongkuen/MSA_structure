package com.example.user.exception.writer;

import com.example.user.exception.ErrorCode;
import lombok.Getter;

@Getter
public class WriterException extends RuntimeException {

    private final ErrorCode errorCode;

    public WriterException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
