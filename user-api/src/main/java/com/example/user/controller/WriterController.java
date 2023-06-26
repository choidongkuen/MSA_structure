package com.example.user.controller;

import com.example.user.dto.RegisterWriterRequestDto;
import com.example.user.service.WriterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/writer")
@RestController
public class WriterController {

    private final WriterService writerService;

    @PostMapping
    public ResponseEntity<Long> registerWriter(
            @Valid @RequestBody RegisterWriterRequestDto request
    ) {
        return new ResponseEntity<>(this.writerService.registerWriter(request), HttpStatus.CREATED);
    }
}
