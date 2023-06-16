package com.example.monolithic.service;

import com.example.monolithic.domain.entity.Writer;
import com.example.monolithic.domain.repository.WebBookRepository;
import com.example.monolithic.domain.repository.WriterRepository;
import com.example.monolithic.dto.RegisterWebBookRequestDto;
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
    private final WebBookRepository webBookRepository;

    @Transactional
    public Long registerWriter(RegisterWriterRequestDto request) {

        checkWriterExist(request);

        return this.writerRepository.save(request.ToEntity())
                                    .getId();
    }

    private void checkWriterExist(RegisterWriterRequestDto request) {
        if (this.writerRepository.countByEmail(request.getEmail()) > 0) {
            throw new RuntimeException("이미 존재하는 작가입니다.");
        }
    }

    public Long registerWebBook(RegisterWebBookRequestDto request) {

        return this.
    }
}
