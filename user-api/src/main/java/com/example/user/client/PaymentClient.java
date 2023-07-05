package com.example.user.client;

import com.example.user.dto.WebBookChapterPayRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// http://localhost:8091/webBook/{chapterId}/pay

@FeignClient(name = "payment", url = "${external-api.payment.url}")
public interface PaymentClient {
    @PostMapping("/webBook/{chapterId}/pay")
    Long webBookChapterPayment(
            @PathVariable(name = "chapterId") Long chapterId,
            @RequestBody WebBookChapterPayRequestDto request
    );
}
