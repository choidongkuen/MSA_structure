package com.example.monolithic.dto;

import com.example.monolithic.domain.entity.WebBookChapter;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebBookChapterDto {

    private Long id;

    private Integer episode;

    private String name;

    private String description;

    private Integer price;

    private String webBookTitle;

    public static WebBookChapterDto from(WebBookChapter webBookChapter) {
        return WebBookChapterDto.builder()
                                .id(webBookChapter.getId())
                                .episode(webBookChapter.getEpisode())
                                .name(webBookChapter.getName())
                                .description(webBookChapter.getDescription())
                                .price(webBookChapter.getPrice())
                                .webBookTitle(webBookChapter.getWebBook().getTitle())
                                .build();
    }
}
