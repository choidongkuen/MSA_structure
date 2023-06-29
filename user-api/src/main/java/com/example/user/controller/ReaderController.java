package com.example.user.controller;

import com.example.user.dto.RegisterReaderRequestDto;
import com.example.user.service.ReaderService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/reader")
@Tag(name = "Reader", description = "독자(Reader) api document")
@RestController
public class ReaderController {

    private final ReaderService readerService;

    @PostMapping
    public ResponseEntity<Long> registerReader(
            @Valid @RequestBody RegisterReaderRequestDto request
    ) {
        return new ResponseEntity<>(this.readerService.registerReader(request), HttpStatus.CREATED);
    }
}
