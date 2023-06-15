package com.example.monolithic.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterWriterRequestDto {


    @Size(min = 0, max = 255)
    private String name;

    @Email
    private String email;
}
