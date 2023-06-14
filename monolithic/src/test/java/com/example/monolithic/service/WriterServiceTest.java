package com.example.monolithic.service;

import com.example.monolithic.domain.entity.Writer;
import com.example.monolithic.domain.repository.WriterRepository;
import com.example.monolithic.dto.RegisterWriterRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WriterServiceTest {

    @Mock
    private WriterRepository writerRepository;

    @InjectMocks
    private WriterService writerService;

    @Test
    @DisplayName("작가 등록 성공")
    void registerWriterInSuccess() {

        // given

        RegisterWriterRequestDto request = RegisterWriterRequestDto
                .builder()
                .name("최동근")
                .email("danaver12@daum.net")
                .build();

        given(this.writerRepository.countByEmail(any()))
                .willReturn(0);

        given(this.writerRepository.save(any()))
                .willReturn(
                        Writer.builder()
                              .id(1L)
                              .name("최동근")
                              .email("danaver13@gmail.com")
                              .build());

        // when
        Long result = this.writerService.registerWriter(request);

        // then
        assertEquals(1L, result);
        assertThat(1L).isEqualTo(result);
        verify(writerRepository, times(1)).save(any());
        verify(writerRepository, times(1)).countByEmail(any());
    }

}