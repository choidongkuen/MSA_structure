package com.example.webbook.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetWebBookChaptersResponseDto {

    private Integer episode;

    private String title;

    private String description;

    private Integer price;
}
