package com.example.user.exception.reader;

import com.example.user.controller.ReaderController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = ReaderController.class)
public class ReaderExceptionHandler {
}
