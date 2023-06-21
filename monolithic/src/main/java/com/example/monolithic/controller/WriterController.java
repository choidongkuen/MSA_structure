package com.example.monolithic.controller;

import com.example.monolithic.dto.RegisterWebBookChapterRequestDto;
import com.example.monolithic.dto.RegisterWebBookRequestDto;
import com.example.monolithic.dto.RegisterWriterRequestDto;
import com.example.monolithic.service.WriterService;
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

@Slf4j
@RequestMapping("/api/v1/writer")
@RequiredArgsConstructor
@Tag(name = "Writer", description = "작가 API document")
@RestController
public class WriterController {

    private final WriterService writerService;

    @Operation(summary = "[작가 등록 컨트롤러]", description = "[This is a registerWriterController]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "[작가 등록 성공]"),
            @ApiResponse(responseCode = "400", description = "[작가 등록 실패]")
    })
    @PostMapping()
    public ResponseEntity<Long> registerWriter(
            @Valid @RequestBody RegisterWriterRequestDto request
    ) {
        return new ResponseEntity<>(this.writerService.registerWriter(request), HttpStatus.CREATED);
    }

    @Operation(summary = "[웹 소설 등록 컨트롤러]", description = "[This is a registerWebBookController]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "[웹 소설 등록 성공]"),
            @ApiResponse(responseCode = "400", description = "[웹 소설 등록 실패]")
    })
    @PostMapping("/{writerId}/webBook")
    public ResponseEntity<Long> registerWebBook(
            @PathVariable(name = "writerId") Long id,
            @Valid @RequestBody RegisterWebBookRequestDto request
    ) {
        return new ResponseEntity<>(this.writerService.registerWebBook(id, request), HttpStatus.CREATED);
    }

    @Operation(summary = "[웹 소설 챕터 등록 컨트롤러]", description = "[This is a registerWebBookChapterController]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "[웹 소설 챕터 등록 성공]"),
            @ApiResponse(responseCode = "400", description = "[웹 소설 챕터 등록 실패]")
    })
    @PostMapping("/{writerId}/webBook/{webBookId}")
    public ResponseEntity<Long> registerWebBookChapter(
            @PathVariable(name = "writerId") Long writerId,
            @PathVariable(name = "webBookId") Long webBookId,
            @Valid @RequestBody RegisterWebBookChapterRequestDto request
    ) {
        return new ResponseEntity<>(
                this.writerService.registerWebBookChapter(writerId, webBookId, request), HttpStatus.CREATED
        );
    }
}
