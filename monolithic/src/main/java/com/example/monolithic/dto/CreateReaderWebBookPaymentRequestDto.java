package com.example.monolithic.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReaderWebBookPaymentRequestDto {

    @NotNull
    private Long webBookChapterId;

    @NotNull
    private Integer price;
}
