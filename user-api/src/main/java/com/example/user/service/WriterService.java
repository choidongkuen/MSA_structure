package com.example.user.service;

import com.example.user.domain.repository.WriterRepository;
import com.example.user.dto.RegisterWriterRequestDto;
import com.example.user.exception.ErrorCode;
import com.example.user.exception.writer.WriterException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class WriterService {

    private final WriterRepository writerRepository;

    @Transactional
    public Long registerWriter(RegisterWriterRequestDto request) {
        if (this.writerRepository.countByEmail(request.getEmail()) > 0) {
            throw new WriterException(ErrorCode.WRITER_NOT_FOUND);
        }
        return this.writerRepository.save(request.toEntity())
                                    .getId();
    }
}
