package com.example.payment.dto;

import com.example.payment.domain.entity.WebBookChapterPayment;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebBookChapterPaymentRequestDto {

    @NotNull
    private Long readerId;

    @NotNull
    private Long writerId;

    @NotNull
    private Long amount;

    public WebBookChapterPayment toEntity(Long chapterId) {
        return WebBookChapterPayment.builder()
                                    .readerId(readerId)
                                    .writerId(writerId)
                                    .amount(amount)
                                    .webBookChapterId(chapterId)
                                    .createdAt(LocalDateTime.now())
                                    .build();
    }
}
