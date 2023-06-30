package com.example.user.service;

import com.example.user.client.WebBookClient;
import com.example.user.domain.entity.ReaderWebBookChapter;
import com.example.user.domain.repository.ReaderRepository;
import com.example.user.domain.repository.ReaderWebBookRepository;
import com.example.user.dto.GetAllWebBooksResponseDto;
import com.example.user.dto.RegisterReaderRequestDto;
import com.example.user.dto.WebBookChapterPayRequestDto;
import com.example.user.dto.WebBookChapterPayResponseDto;
import com.example.user.exception.ErrorCode;
import com.example.user.exception.reader.ReaderException;
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
    private final ReaderWebBookRepository readerWebBookRepository;
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

    @Transactional
    public WebBookChapterPayResponseDto readerPayWebBookChapter(Long readerId, WebBookChapterPayRequestDto request) {

        this.readerRepository.findById(readerId)
                             .orElseThrow(() -> new ReaderException(ErrorCode.READER_NOT_FOUND));

        // webBookClient
        // paymentClient
        this.readerWebBookRepository.save(
                ReaderWebBookChapter.builder()
                                    .readerId(readerId)
                                    .webBookChapterId(request.getWebBookChapterId())
                                    .paymentAmount(request.getAmount())
                                    .build()


        );
        return null;
    }
}
