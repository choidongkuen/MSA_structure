package com.example.monolithic.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private final String errorMessage;
    private final HttpStatus httpStatus;

    public ErrorResponse(ErrorCode errorCode, HttpStatus httpStatus) {
        this.errorMessage = errorCode.getErrorMessage();
        this.httpStatus = httpStatus;
    }

    public static ErrorResponse of(ErrorCode errorCode, HttpStatus httpStatus) {
        return new ErrorResponse(errorCode, httpStatus);
    }
}
