package com.example.user.controller;

import com.example.user.dto.RegisterReaderRequestDto;
import com.example.user.service.ReaderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/reader")
@Tag(name = "Reader", description = "독자(Reader) api document")
@RestController
public class ReaderController {

    private final ReaderService readerService;

    @Operation(summary = "[작가 등록 컨트롤러]", description = "[This is a registerReaderController]")
    @PostMapping
    public ResponseEntity<Long> registerReader(
            @Valid @RequestBody RegisterReaderRequestDto request
    ) {
        return new ResponseEntity<>(this.readerService.registerReader(request), HttpStatus.CREATED);
    }


    @Operation(summary = "[존재하는 모든 웹 소설과 해당하는 웹 소설의 모든 챕터 조회 컨트롤러]",
            description = "[This is a getAllWebBooksAndWebBookChaptersController]"
    )
    @GetMapping("/webBooks")
    public ResponseEntity<Object> getAllWebBooksAndWebBookChapters() {
        return new ResponseEntity<>(
                this.readerService.getAllWebBooksAndWebBookChapters(), HttpStatus.OK);
    }
}
