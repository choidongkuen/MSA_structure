package com.example.user.exception.writer;

import com.example.user.controller.WriterController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = WriterController.class)
public class WriterExceptionHandler {
}
