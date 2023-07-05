package com.example.user.dto;

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

    private Long price;
}
