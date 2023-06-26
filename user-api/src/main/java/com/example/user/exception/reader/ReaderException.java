package com.example.user.exception.reader;

import com.example.user.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ReaderException extends RuntimeException {

    private final ErrorCode errorCode;

    public ReaderException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
