package com.example.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebBookChapterPayRequestDto {

    private Long webBookChapterId;

    private Integer amount;

}
