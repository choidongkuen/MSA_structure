package com.example.monolithic.controller;

import com.example.monolithic.dto.RegisterWebBookRequestDto;
import com.example.monolithic.dto.RegisterWriterRequestDto;
import com.example.monolithic.service.WriterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/writer")
@RequiredArgsConstructor
@Tag(name = "Write", description = "작가 API document")
@RestController
public class WriterController {

    private final WriterService writerService;

    @PostMapping("/")
    public ResponseEntity<Long> registerWriter(
            @Valid @RequestBody RegisterWriterRequestDto request
    ) {
        return ResponseEntity.ok(this.writerService.registerWriter(request));
    }

    @PostMapping("/{writerId}/webBook")
    public ResponseEntity<Long> registerWebBook(
            @PathVariable(name = "writerId") Long id,
            @Valid @RequestBody RegisterWebBookRequestDto request
    ) {
        return ResponseEntity.ok(this.writerService.registerWebBook(id, request));
    }
}
