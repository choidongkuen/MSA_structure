package com.example.user.controller;

import com.example.user.dto.GetWebBookChaptersResponseDto;
import com.example.user.dto.RegisterReaderRequestDto;
import com.example.user.dto.WebBookChapterPayRequestDto;
import com.example.user.dto.WebBookChapterPayResponseDto;
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

    @Operation(summary = "[독자 특정 웹 소설 챕터 상세 조회 컨트롤러]", description = "[This is a readerGetWebBookChapterDetail]")
    @GetMapping("/{chapterId}/detail")
    public ResponseEntity<GetWebBookChaptersResponseDto> getWebBookChapterDetail(
            @PathVariable(name = "chapterId") Long webBookId
    ) {
        return new ResponseEntity<>(
                this.readerService.getWebBookChapterDetail(webBookId), HttpStatus.OK
        );
    }

    @Operation(summary = "[독자 웹 소설 챕터 결제 컨트롤러]", description = "[This is a readerPayWebBooChapterController]")
    @PostMapping("/{chapterId}/payment")
    public ResponseEntity<WebBookChapterPayResponseDto> readerPayWebBookChapter(
            @PathVariable(value = "chapterId") Long chapterId,
            @RequestBody WebBookChapterPayRequestDto request
    ) {
        return new ResponseEntity<>(
                this.readerService.readerPayWebBookChapter(chapterId, request), HttpStatus.CREATED
        );
    }
}
