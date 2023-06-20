package com.example.monolithic.service;

import com.example.monolithic.domain.entity.WebBook;
import com.example.monolithic.domain.entity.WebBookChapter;
import com.example.monolithic.domain.entity.Writer;
import com.example.monolithic.domain.repository.WebBookChapterRepository;
import com.example.monolithic.domain.repository.WebBookRepository;
import com.example.monolithic.domain.repository.WriterRepository;
import com.example.monolithic.dto.RegisterWebBookChapterRequestDto;
import com.example.monolithic.dto.RegisterWebBookRequestDto;
import com.example.monolithic.dto.RegisterWriterRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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

    @Mock
    private WebBookRepository webBookRepository;

    @Mock
    private WebBookChapterRepository webBookChapterRepository;

    @InjectMocks
    private WriterService writerService;

    @Test
    @DisplayName("작가 등록 서비스 성공")
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

    @Test
    @DisplayName("웹 소설 등록 서비스 성공")
    void registerWebBookInSuccess() {

        // given

        RegisterWebBookRequestDto request = RegisterWebBookRequestDto
                .builder()
                .title("제목1")
                .description("설명1")
                .build();

        given(this.writerRepository.findById(any()))
                .willReturn(Optional.ofNullable(Writer.builder()
                                                      .name("최동근")
                                                      .email("danaver12@daum.net")
                                                      .id(1L)
                                                      .build()));

        given(this.webBookRepository.save(any()))
                .willReturn(WebBook.builder()
                                   .id(1L)
                                   .title("제목1")
                                   .description("설명1")
                                   .writer(
                                           Writer.builder()
                                                 .name("이름1")
                                                 .email("danaver12@daum.net")
                                                 .build()
                                   )
                                   .build());

        // when
        Long result = this.writerService.registerWebBook(1L, request);

        // then
        assertThat(1L).isEqualTo(result);
    }

    @Test
    @DisplayName("웹 소설 챕터 등록 서비스 성공")
    void registerWebBookChapterInSuccess() {

        // given
        RegisterWebBookChapterRequestDto request =
                RegisterWebBookChapterRequestDto.builder()
                                                .name("챕터1")
                                                .episode(1)
                                                .description("설명")
                                                .build();

        given(this.writerRepository.findById(any()))
                .willReturn(Optional.ofNullable(Writer.builder()
                                                      .id(1L)
                                                      .name("최동근")
                                                      .email("danaver12@daum.net")
                                                      .build()));

        given(this.webBookRepository.findById(any()))
                .willReturn(Optional.ofNullable(WebBook.builder()
                                                       .id(1L)
                                                       .title("제목1")
                                                       .description("설명")
                                                       .writer(Writer.builder()
                                                                     .id(1L)
                                                                     .name("최동근")
                                                                     .email("danaver12@daum.net")
                                                                     .build())
                                                       .build()
                ));

        given(this.webBookChapterRepository.save(any()))
                .willReturn(WebBookChapter.builder()
                                          .id(1L)
                                          .episode(1)
                                          .name("최동근")
                                          .description("설명")
                                          .webBook(
                                                  WebBook.builder()
                                                         .id(1L)
                                                         .title("제목1")
                                                         .description("설명")
                                                         .writer(
                                                                 Writer.builder()
                                                                       .id(1L)
                                                                       .name("최동근")
                                                                       .email("danaver12@daum.net")
                                                                       .build()
                                                         )
                                                         .build()
                                          ).build()
                );

        // when
        Long result = this.writerService.registerWebBookChapter(1L, 1L, request);

        // then
        assertThat(1L).isEqualTo(result);

    }

}