package com.example.monolithic.service;

import com.example.monolithic.domain.entity.Writer;
import com.example.monolithic.domain.repository.WebBookRepository;
import com.example.monolithic.domain.repository.WriterRepository;
import com.example.monolithic.dto.RegisterWebBookRequestDto;
import com.example.monolithic.dto.RegisterWriterRequestDto;
import com.example.monolithic.exception.ErrorCode;
import com.example.monolithic.exception.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            throw new WriterException(ErrorCode.WRITER_ALREADY_EXIST);
        }
    }

    @Transactional
    public Long registerWebBook(Long id, RegisterWebBookRequestDto request) {

        Writer writer = this.writerRepository.findById(id)
                                             .orElseThrow(() -> new WriterException(ErrorCode.WRITER_NOT_FOUND));

        return this.webBookRepository.save(request.ToEntity(writer))
                                     .getId();
    }
}
