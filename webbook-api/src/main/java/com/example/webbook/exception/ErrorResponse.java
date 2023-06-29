package com.example.webbook.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse {
    private final String errorMessage;
    private final HttpStatus httpStatus;

    public ErrorResponse(ErrorCode errorCode) {
        this.errorMessage = errorCode.getErrorMessage();
        this.httpStatus = errorCode.getHttpStatus();
    }

    public static ErrorResponse from(ErrorCode errorCode) {
        return new ErrorResponse(errorCode);
    }

}
