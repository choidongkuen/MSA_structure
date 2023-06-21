package com.example.monolithic.exception.writer;

import com.example.monolithic.controller.WriterController;
import com.example.monolithic.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = WriterController.class)
public class WriterExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(WriterException.class)
    public ResponseEntity<ErrorResponse> writerExceptionHandler(WriterException exception) {
        return ResponseEntity.badRequest()
                             .body(ErrorResponse.of(exception.getErrorCode(), HttpStatus.BAD_REQUEST));
    }
}
