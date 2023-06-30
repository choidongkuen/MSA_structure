package com.example.webbook.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllWebBooksResponseDto {


    private String title;

    private String description;

    private Long writer;

    private List<GetWebBookChaptersResponseDto> webBookChapters;
}
