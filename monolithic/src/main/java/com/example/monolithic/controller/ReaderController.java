package com.example.monolithic.controller;

import com.example.monolithic.dto.RegisterReaderRequestDto;
import com.example.monolithic.service.ReaderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
}
