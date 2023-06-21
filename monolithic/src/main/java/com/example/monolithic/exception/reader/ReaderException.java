package com.example.monolithic.exception.reader;


import com.example.monolithic.exception.ErrorCode;
import lombok.Getter;

@Getter
public class ReaderException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String errorMessage;

    public ReaderException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getErrorMessage();
    }

}
