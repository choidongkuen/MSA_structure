package com.example.webbook.dto;

import com.example.webbook.domain.entity.WebBook;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterWebBookRequestDto {

    @NotBlank
    @Size(max = 255)
    private String title;

    @NotBlank
    @Size(max = 255)
    private String description;

    @NotNull
    private Long writer;

    public WebBook toEntity() {
        return WebBook.builder()
                      .title(title)
                      .description(description)
                      .writer(writer)
                      .build();
    }
}
