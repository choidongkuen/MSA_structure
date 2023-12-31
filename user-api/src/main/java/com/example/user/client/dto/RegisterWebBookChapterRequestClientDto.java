package com.example.user.client.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterWebBookChapterRequestClientDto {

    private Integer episode;

    private String title;

    private String description;

    private Integer price;
}

