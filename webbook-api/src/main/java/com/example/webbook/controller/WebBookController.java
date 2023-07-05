package com.example.webbook.controller;

import com.example.webbook.dto.GetWebBookChaptersResponseDto;
import com.example.webbook.dto.RegisterWebBookChapterRequestDto;
import com.example.webbook.dto.RegisterWebBookRequestDto;
import com.example.webbook.service.WebBookService;
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
@Tag(name = "WebBook", description = "웹 소설(WebBook) api document")
@RestController
public class WebBookController {

    private final WebBookService webBookService;

    @Operation(summary = "[웹 소설 등록 컨트롤러]", description = "[This is a registerWebBookController]")
    @PostMapping("/writer/webBook")
    public ResponseEntity<Long> registerWebBook(
            @Valid @RequestBody RegisterWebBookRequestDto request
    ) {
        return new ResponseEntity<>(this.webBookService.registerWebBook(request), HttpStatus.CREATED);
    }

    @Operation(summary = "[웹 소설 챕터 등록 컨트롤러]", description = "[This is a registerWebBookChapterController]")
    @PostMapping("/writer/webBook/{webBookId}")
    public ResponseEntity<Long> registerWebBookChapter(
            @PathVariable(name = "webBookId") Long webBookId,
            @Valid @RequestBody RegisterWebBookChapterRequestDto request) {
        return new ResponseEntity<>(this.webBookService.registerWebBookChapter(webBookId, request), HttpStatus.CREATED);
    }

    @Operation(summary = "[모든 웹 소설 및 웹 소설 챕터 조회 컨트롤러]", description = "[This is a getAllWebBooksAndWebBookChapterController]")
    @GetMapping("/webBooks")
    public ResponseEntity<Object> getAllWebBooksAndWebBookChapter() {
        return new ResponseEntity<>(this.webBookService.getAllWebBooksAndWebBookChapter(), HttpStatus.OK);
    }

    @Operation(summary = "[특정 웹 소설 챕터 상세 조회 컨트롤러]", description = "[This is a getWebBookChapterDetailController]")
    @GetMapping("/{chapterId}/detail")
    public ResponseEntity<GetWebBookChaptersResponseDto> getWebBookChapterDetail(
            @PathVariable(value = "chapterId") Long chapterId
    ) {
        return new ResponseEntity<>(this.webBookService.getWebBookChapterDetail(chapterId), HttpStatus.OK);
    }
}
