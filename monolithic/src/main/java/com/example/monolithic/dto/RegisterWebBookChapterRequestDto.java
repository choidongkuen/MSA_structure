package com.example.monolithic.dto;

import com.example.monolithic.domain.entity.WebBook;
import com.example.monolithic.domain.entity.WebBookChapter;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterWebBookChapterRequestDto {

    @NotNull
    @Min(1)
    private Integer episode;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String description;

    public WebBookChapter ToEntity(WebBook webBook) {
        return WebBookChapter.builder()
                             .episode(episode)
                             .name(name)
                             .description(description)
                             .webBook(webBook)
                             .build();
    }
}
