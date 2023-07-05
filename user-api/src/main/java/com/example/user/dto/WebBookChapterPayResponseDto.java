package com.example.user.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 결제 응답 :
 * 1. 웹 소설 챕터 아이디
 * 2. 웹 소설 챕터 제목
 * 3. 웹 소설 설명
 * 5. 결제 일시
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebBookChapterPayResponseDto {

    // 웹 소설 챕터 아이디
    private Long webBookChapterId;
    // 웹 소설 챕터
    private String title;

    private String description;

    private LocalDateTime paymentAt;
}
