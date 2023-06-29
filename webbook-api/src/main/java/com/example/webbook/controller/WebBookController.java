package com.example.webbook.controller;

import com.example.webbook.dto.RegisterWebBookRequestDto;
import com.example.webbook.service.WebBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class WebBookController {

    private final WebBookService webBookService;

    @PostMapping("/writer/webBook")
    public ResponseEntity<Long> registerWebBook(
            @Valid @RequestBody RegisterWebBookRequestDto request
    ) {
        return new ResponseEntity<>(this.webBookService.registerWebBook(request), HttpStatus.CREATED);
    }
}
