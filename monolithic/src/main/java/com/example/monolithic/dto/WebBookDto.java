package com.example.monolithic.dto;

import com.example.monolithic.domain.entity.WebBook;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebBookDto {

    private Long id;

    private String title;

    private String description;

    private String writerName;

    public static WebBookDto from(WebBook webBook) {
        return WebBookDto.builder()
                         .id(webBook.getId())
                         .title(webBook.getTitle())
                         .description(webBook.getDescription())
                         .writerName(webBook.getWriter().getName())
                         .build();
    }
}
