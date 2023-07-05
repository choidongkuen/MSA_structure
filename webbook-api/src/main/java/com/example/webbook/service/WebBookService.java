package com.example.webbook.service;

import com.example.webbook.domain.entity.WebBook;
import com.example.webbook.domain.entity.WebBookChapter;
import com.example.webbook.domain.repository.WebBookChapterRepository;
import com.example.webbook.domain.repository.WebBookRepository;
import com.example.webbook.dto.GetAllWebBooksResponseDto;
import com.example.webbook.dto.GetWebBookChaptersResponseDto;
import com.example.webbook.dto.RegisterWebBookChapterRequestDto;
import com.example.webbook.dto.RegisterWebBookRequestDto;
import com.example.webbook.exception.ErrorCode;
import com.example.webbook.exception.WebBookException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public Object getAllWebBooksAndWebBookChapter() {

        return this.webBookRepository.findAll().stream()
                                     .map(webBook -> GetAllWebBooksResponseDto.builder()
                                                                              .title(webBook.getTitle())
                                                                              .description(webBook.getDescription())
                                                                              .writer(webBook.getWriter())
                                                                              .webBookChapters(webBookChapterRepository.findByWebBook(webBook).stream()
                                                                                                                       .map(WebBookChapter::from)
                                                                                                                       .collect(Collectors.toList()))
                                                                              .build())
                                     .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GetWebBookChaptersResponseDto getWebBookChapterDetail(Long chapterId) {
        WebBookChapter webBookChapter = this.webBookChapterRepository.findById(chapterId)
                                                                     .orElseThrow(() -> new WebBookException(ErrorCode.WEB_BOOK_CHAPTER_NOT_FOUND));

        return webBookChapter.from();
    }
}
