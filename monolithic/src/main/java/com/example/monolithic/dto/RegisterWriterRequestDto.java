package com.example.monolithic.dto;

import io.swagger.annotations.ApiParam;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterWriterRequestDto {

    @ApiParam(value = "작가의 이름", example = "최동근")
    @Size(min = 0, max = 255)
    private String name;
}
