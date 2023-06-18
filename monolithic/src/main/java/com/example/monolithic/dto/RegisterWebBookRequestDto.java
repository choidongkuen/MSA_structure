package com.example.monolithic.dto;

import com.example.monolithic.domain.entity.WebBook;
import com.example.monolithic.domain.entity.Writer;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

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

    public WebBook ToEntity(Writer writer) {
        return WebBook.builder()
                      .writer(writer)
                      .title(title)
                      .description(description)
                      .createdAt(LocalDateTime.now())
                      .build();
    }
}
