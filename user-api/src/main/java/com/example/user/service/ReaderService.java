package com.example.user.service;

import com.example.user.client.WebBookClient;
import com.example.user.domain.repository.ReaderRepository;
import com.example.user.dto.GetAllWebBooksResponseDto;
import com.example.user.dto.RegisterReaderRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final WebBookClient webBookClient;

    @Transactional
    public Long registerReader(RegisterReaderRequestDto request) {

        return this.readerRepository.save(request.toEntity())
                                    .getId();
    }

    @Transactional(readOnly = true)
    public List<GetAllWebBooksResponseDto> getAllWebBooksAndWebBookChapters() {
        return this.webBookClient.getAllWebBooksAndWebBookChapters();
    }
}
