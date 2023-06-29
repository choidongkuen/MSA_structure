package com.example.user.client.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterWebBookRequestClientDto {

    private String title;

    private String description;

    private Long writer;
}
