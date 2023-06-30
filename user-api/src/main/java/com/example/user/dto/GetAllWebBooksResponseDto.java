package com.example.user.dto;

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

    private String writerName;

    private List<GetWebBookChaptersResponseDto> webBookChapters;
}
