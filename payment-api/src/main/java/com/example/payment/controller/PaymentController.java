package com.example.payment.controller;

import com.example.payment.dto.WebBookChapterPaymentRequestDto;
import com.example.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/webBook/{chapterId}/pay")
    public ResponseEntity<Long> webBookChapterPayment(
            @PathVariable(name = "chapterId") Long chapterId,
            @RequestBody WebBookChapterPaymentRequestDto request
    ) {
        return new ResponseEntity<>(
                this.paymentService.payWebBookChapter(chapterId, request), HttpStatus.CREATED
        );
    }
}
