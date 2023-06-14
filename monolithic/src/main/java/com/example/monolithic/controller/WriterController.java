package com.example.monolithic.controller;

import com.example.monolithic.dto.RegisterWriterRequestDto;
import com.example.monolithic.service.WriterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/writer")
@RequiredArgsConstructor
@RestController
public class WriterController {

    private final WriterService writerService;

    @PostMapping("/")
    public ResponseEntity<Long> registerWriter(
            @Valid RegisterWriterRequestDto request
    ) {
        return ResponseEntity.ok(this.writerService.registerWriter(request));
    }
}
