package com.example.monolithic.service;

import com.example.monolithic.domain.repository.ReaderRepository;
import com.example.monolithic.dto.RegisterReaderRequestDto;
import com.example.monolithic.exception.ErrorCode;
import com.example.monolithic.exception.reader.ReaderException;
import com.example.monolithic.util.Encryptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final Encryptor encryptor;

    @Transactional
    public Long registerReader(RegisterReaderRequestDto request) {

        try {
            request.setRegistrationNumber(encryptor.encrypt(request.getRegistrationNumber()));
        } catch (Exception e) {
            throw new ReaderException(ErrorCode.INTER_SERVER_ERROR);
        }
        return this.readerRepository.save(request.toEntity()).getId();
    }
}
