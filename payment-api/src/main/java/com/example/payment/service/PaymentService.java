package com.example.payment.service;

import com.example.payment.domain.repository.WebBookChapterRepository;
import com.example.payment.dto.WebBookChapterPaymentRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentService {

    private final WebBookChapterRepository webBookChapterRepository;

    @Transactional
    public Long payWebBookChapter(Long chapterId, WebBookChapterPaymentRequestDto request) {
        return this.webBookChapterRepository.save(request.toEntity(chapterId))
                                            .getId();
    }
}
