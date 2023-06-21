package com.example.monolithic.exception.reader;

import com.example.monolithic.controller.ReaderController;
import com.example.monolithic.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = ReaderController.class)
public class ReaderExceptionHandler {

    @ExceptionHandler(ReaderException.class)
    public ResponseEntity<ErrorResponse> readerExceptionHandler(ReaderException e) {
        return ResponseEntity.badRequest()
                             .body(ErrorResponse.of(e.getErrorCode(), HttpStatus.BAD_REQUEST));

    }
}
