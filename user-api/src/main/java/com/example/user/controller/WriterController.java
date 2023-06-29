package com.example.user.controller;

import com.example.user.dto.RegisterWebBookChapterRequestDto;
import com.example.user.dto.RegisterWebBookRequestDto;
import com.example.user.dto.RegisterWriterRequestDto;
import com.example.user.service.WriterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 작가 등록 -> http://localhost:8091/writer
 * 작가 웹 소설 등록 -> http://localhost:8091/writer/{writerId}/webBook
 * 작가 웹 소설 챕터 등록 -> http://localhost:8091/writer/{writerId}/webBook/{webBookId}
 */

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/writer")
@Tag(name = "Writer", description = "작가 API document")
@RestController
public class WriterController {

    private final WriterService writerService;

    @Operation(summary = "[작가 등록 컨트롤러]", description = "[This is a registerWriterController]")
    @PostMapping
    public ResponseEntity<Long> registerWriter(
            @Valid @RequestBody RegisterWriterRequestDto request
    ) {
        return new ResponseEntity<>(this.writerService.registerWriter(request), HttpStatus.CREATED);
    }

    @Operation(summary = "[웹 소설 등록 컨트롤러]", description = "[This is a registerWebBookController]")
    @PostMapping("/{writerId}/webBook")
    public ResponseEntity<Long> registerWebBook(
            @PathVariable(name = "writerId") Long writerId,
            @RequestBody RegisterWebBookRequestDto request
    ) {
        return new ResponseEntity<>(this.writerService.registerWebBook(writerId, request), HttpStatus.CREATED);
    }

    @Operation(summary = "[웹 소설 챕터 등록 컨트롤러]", description = "[This is a registerWebBookChapterController]")
    @PostMapping("/{writerId}/webBook/{webBookId}")
    public ResponseEntity<Long> registerWebBookChapter(
            @PathVariable(name = "writerId") Long writerId,
            @PathVariable(name = "webBookId") Long webBookId,
            @RequestBody RegisterWebBookChapterRequestDto request
    ) {
        return new ResponseEntity<>(this.writerService.registerWebBookChapter(writerId, webBookId, request), HttpStatus.CREATED);
    }
}
