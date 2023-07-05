package com.example.user.service;

import com.example.user.client.PaymentClient;
import com.example.user.client.WebBookClient;
import com.example.user.domain.entity.ReaderWebBookChapter;
import com.example.user.domain.repository.ReaderRepository;
import com.example.user.domain.repository.ReaderWebBookRepository;
import com.example.user.dto.*;
import com.example.user.exception.ErrorCode;
import com.example.user.exception.reader.ReaderException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final ReaderWebBookRepository readerWebBookRepository;
    private final WebBookClient webBookClient;
    private final PaymentClient paymentClient;

    @Transactional
    public Long registerReader(RegisterReaderRequestDto request) {

        return this.readerRepository.save(request.toEntity())
                                    .getId();
    }

    @Transactional(readOnly = true)
    public List<GetAllWebBooksResponseDto> getAllWebBooksAndWebBookChapters() {
        return this.webBookClient.getAllWebBooksAndWebBookChapters();
    }

    @Transactional(readOnly = true)
    public GetWebBookChaptersResponseDto getWebBookChapterDetail(Long chapterId) {
        return this.webBookClient.getWebBookChapterDetail(chapterId);
    }


    /*
        1. webBookClient 을 통해 해당 웹 소설 챕터의 상세정보를 가져온다.(실제 웹 소설 챕터 가격과 요청 금액이 다르면 예외 처리)
        2. 결제 요청
        3. readerWebBook 저장
        4. WebBookChapterPayResponseDto 반환
     */

    @Transactional
    public WebBookChapterPayResponseDto readerPayWebBookChapter(Long chapterId, WebBookChapterPayRequestDto request) {


        // webBookClient
        GetWebBookChaptersResponseDto res
                = this.webBookClient.getWebBookChapterDetail(chapterId);

        // 가격이 요청 금액과 다른 경우
        if (!Objects.equals(res.getPrice(), request.getAmount())) {
            throw new ReaderException(ErrorCode.INTERNAL_SERVER_ERROR);
        }

        // paymentClient
        Long paymentId = this.paymentClient.webBookChapterPayment(chapterId, request);

        this.readerWebBookRepository.save(
                ReaderWebBookChapter.builder()
                                    .readerId(request.getReaderId())
                                    .paymentId(paymentId)
                                    .webBookChapterId(chapterId)
                                    .paymentAmount(request.getAmount())
                                    .build()
        );

        return WebBookChapterPayResponseDto.builder()
                                           .webBookChapterId(chapterId)
                                           .title(res.getTitle())
                                           .description(res.getDescription())
                                           .paymentAt(LocalDateTime.now())
                                           .build();
    }
}
