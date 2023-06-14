package com.example.monolithic.service;

import com.example.monolithic.domain.entity.Writer;
import com.example.monolithic.domain.repository.WriterRepository;
import com.example.monolithic.dto.RegisterWriterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * writer 에 대한 CRUD
 */
@RequiredArgsConstructor
@Service
public class WriterService {

    private final WriterRepository writerRepository;

    @Transactional
    public Long registerWriter(RegisterWriterRequestDto request) {

        return this.writerRepository.save(Writer.builder()
                                                .name(request.getName())
                                                .createdAt(LocalDateTime.now())
                                                .build())
                                    .getId();
    }
}
