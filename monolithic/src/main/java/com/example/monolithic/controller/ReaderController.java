package com.example.monolithic.controller;

import com.example.monolithic.dto.CreateReaderWebBookPaymentRequestDto;
import com.example.monolithic.dto.RegisterReaderRequestDto;
import com.example.monolithic.dto.WebBookChapterDto;
import com.example.monolithic.dto.WebBookDto;
import com.example.monolithic.service.ReaderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequestMapping("/api/v1/reader")
@RequiredArgsConstructor
@Tag(name = "Reader", description = "독자 API document")
@RestController
public class ReaderController {

    private final ReaderService readerService;

    @Operation(summary = "[독자 등록 컨트롤러]", description = "[This is a registerReaderController]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "[독자 등록 성공]"),
            @ApiResponse(responseCode = "400", description = "[독자 등록 실패]")
    })
    @PostMapping()
    public ResponseEntity<Long> registerReader(
            @Valid @RequestBody RegisterReaderRequestDto request
    ) {
        return new ResponseEntity<>(this.readerService.registerReader(request), HttpStatus.CREATED);
    }

    @Operation(summary = "[독자 웹 소설 챕터 조회 컨트롤러]", description = "[This is a getWebBookChapterListController]")
    @GetMapping("/webBook/{webBookId}/chapters")
    public ResponseEntity<List<WebBookChapterDto>> getWebBookChapterList(
            @PathVariable(value = "webBookId") Long webBookId
    ) {
        return new ResponseEntity<>(this.readerService.getWebBookChapterList(webBookId), HttpStatus.OK);
    }

    @Operation(summary = "[독자 웹 소설 조회 컨트롤러]", description = "[This is a getWebBookListController]")
    @GetMapping("/webBook")
    public ResponseEntity<List<WebBookDto>> getWebBookList() {
        return new ResponseEntity<>(this.readerService.getWebBookList(), HttpStatus.OK);
    }

    @Operation(summary = "[독자의 웹 소설 챕터 결제 컨트롤러]", description = "[This is a readerPayWebBookChapterController]")
    @PostMapping("{readerId}/pay")
    public ResponseEntity<Long> readerPaymentWebBookChapter(
            @PathVariable(value = "readerId") Long readerId,
            @RequestBody CreateReaderWebBookPaymentRequestDto request
    ) {
        return new ResponseEntity<>(this.readerService.createReaderPaymentWebBookChapter(readerId, request), HttpStatus.CREATED);
    }

    @Operation(summary = "[독자가 결제한 웹 소설 챕터 조회 컨트롤러]", description = "[This is a getReader's WebBookChapterListController]")
    @GetMapping("{readerId}/webBook/{webBookChapterId}")
    public ResponseEntity<List<WebBookChapterDto>> getReaderWebBookChapterList(
            @PathVariable(value = "readerId") Long readerId,
            @PathVariable(value = "webBookChapterId") Long webBookChapterId
    ) {
        return new ResponseEntity<>(
                this.readerService.getWebBookChapterList(readerId, webBookChapterId), HttpStatus.OK);
    }
}
