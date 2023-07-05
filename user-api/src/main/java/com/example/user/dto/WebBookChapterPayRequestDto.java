package com.example.user.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebBookChapterPayRequestDto {

    @NotNull
    private Long readerId;

    @NotNull
    private Long writerId;

    @NotNull
    private Long amount;
}
