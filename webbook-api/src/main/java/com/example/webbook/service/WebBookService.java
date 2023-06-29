package com.example.webbook.service;

import com.example.webbook.domain.entity.WebBook;
import com.example.webbook.domain.entity.WebBookChapter;
import com.example.webbook.domain.repository.WebBookChapterRepository;
import com.example.webbook.domain.repository.WebBookRepository;
import com.example.webbook.dto.RegisterWebBookChapterRequestDto;
import com.example.webbook.dto.RegisterWebBookRequestDto;
import com.example.webbook.exception.ErrorCode;
import com.example.webbook.exception.WebBookException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class WebBookService {

    private final WebBookRepository webBookRepository;
    private final WebBookChapterRepository webBookChapterRepository;

    @Transactional
    public Long registerWebBook(RegisterWebBookRequestDto request) {
        return this.webBookRepository.save(request.toEntity())
                                     .getId();

    }

    @Transactional
    public Long registerWebBookChapter(Long webBookId, RegisterWebBookChapterRequestDto request) {
        WebBook webBook = this.webBookRepository.findById(webBookId)
                                                .orElseThrow(() -> new WebBookException(ErrorCode.WEB_BOOK_NOT_FOUND));

        return this.webBookChapterRepository.save(
                WebBookChapter.builder()
                              .episode(request.getEpisode())
                              .webBook(webBook)
                              .price(request.getPrice())
                              .description(request.getDescription())
                              .title(request.getTitle())
                              .build()
        ).getId();
    }
}
