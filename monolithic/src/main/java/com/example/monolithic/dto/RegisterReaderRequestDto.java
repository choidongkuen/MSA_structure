package com.example.monolithic.dto;

import com.example.monolithic.domain.entity.Reader;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReaderRequestDto {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 50)
    private String registrationNumber;

    public Reader toEntity() {
        return Reader.builder()
                     .name(name)
                     .registrationNumber(registrationNumber)
                     .build();
    }
}
