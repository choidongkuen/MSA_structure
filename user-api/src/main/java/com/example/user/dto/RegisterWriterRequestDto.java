package com.example.user.dto;

import com.example.user.domain.entity.Writer;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterWriterRequestDto {

    @Size(min = 0, max = 255)
    @NotBlank
    private String name;

    @Email
    private String email;

    public Writer toEntity() {
        return Writer.builder()
                     .name(name)
                     .email(email)
                     .build();
    }
}
