package com.example.webbook.exception;

import com.example.webbook.controller.WebBookController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = WebBookController.class)
public class WebBookExceptionHandler {

    @ExceptionHandler(WebBookException.class)
    public ResponseEntity<ErrorResponse> webBookExceptionHandler(
            WebBookException exception
    ) {
        return new ResponseEntity<>(
                ErrorResponse.from(exception.getErrorCode()),
                exception.getErrorCode().getHttpStatus()
        );
    }
}
