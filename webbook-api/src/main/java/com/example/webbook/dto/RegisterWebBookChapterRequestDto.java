package com.example.webbook.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterWebBookChapterRequestDto {

    private Integer episode;

    private String title;

    private String description;

    private Integer price;
}
