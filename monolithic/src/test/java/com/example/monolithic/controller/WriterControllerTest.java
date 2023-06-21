package com.example.monolithic.controller;

import com.example.monolithic.dto.RegisterWebBookChapterRequestDto;
import com.example.monolithic.dto.RegisterWebBookRequestDto;
import com.example.monolithic.dto.RegisterWriterRequestDto;
import com.example.monolithic.exception.ErrorCode;
import com.example.monolithic.exception.writer.WriterException;
import com.example.monolithic.service.WriterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WriterController.class)
class WriterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private WriterService writerService;

    @Test
    @DisplayName("작가 등록 컨트롤러 성공")
    void registerWriterInSuccess() {
        // given
        given(this.writerService.registerWriter(any()))
                .willReturn(1L);

        // when
        // then
        try {
            this.mockMvc.perform(post("/api/v1/writer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(
                                RegisterWriterRequestDto.builder()
                                                        .name("최동근")
                                                        .email("danaver12@daum.net")
                                                        .build()
                        ))).andExpect(status().isCreated())
                        .andDo(print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("작가 등록 컨트롤러 실패")
    void registerWriterInFail() {

        // given
        given(this.writerService.registerWriter(any()))
                .willThrow(new WriterException(ErrorCode.WRITER_ALREADY_EXIST));

        try {
            this.mockMvc.perform(post("/api/v1/writer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(
                                RegisterWriterRequestDto.builder()
                                                        .name("최동근")
                                                        .email("danaver12@daum.net")
                                                        .build()
                        ))).andExpect(status().isBadRequest())
                        .andDo(print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("웹 소설 등록 컨트롤러 성공")
    void registerWebBookInSuccess() {
        // given
        given(this.writerService.registerWebBook(any(), any()))
                .willReturn(1L);

        try {
            this.mockMvc.perform(post("/api/v1/writer/1/webBook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(
                                RegisterWebBookRequestDto.builder()
                                                         .title("제목1")
                                                         .description("설명1")
                                                         .build())
                        )).andExpect(status().isCreated())
                        .andDo(print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("웹 소설 등록 컨트롤러 실패")
    void registerWebBookInFail() {

        // given
        given(this.writerService.registerWebBook(any(), any()))
                .willThrow(new WriterException(ErrorCode.WRITER_NOT_FOUND));

        // when
        // then
        try {
            this.mockMvc.perform(post("/api/v1/writer/1/webBook")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(
                                RegisterWebBookRequestDto.builder()
                                                         .title("제목1")
                                                         .description("설명1")
                                                         .build())
                        )).andExpect(status().isBadRequest())
                        .andDo(print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("웹 소설 챕터 등록 컨트롤러 성공")
    void registerWebBookChapterInSuccess() {

        // given
        given(this.writerService.registerWebBookChapter(any(), any(), any()))
                .willReturn(1L);

        // when
        // then
        try {
            this.mockMvc.perform(post("/api/v1/writer/1/webBook/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(
                                RegisterWebBookChapterRequestDto.builder()
                                                                .episode(1)
                                                                .name("제목1")
                                                                .description("설명1")
                                                                .build()
                        )))
                        .andExpect(status().isCreated())
                        .andDo(print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("웹 소설 챕터 등록 컨트롤러 실패")
    void registerWebBookChapterInFail() {

        // given
        given(this.writerService.registerWebBookChapter(any(), any(), any()))
                .willThrow(new WriterException(ErrorCode.WEB_BOOK_NOT_FOUND));


        try {
            this.mockMvc.perform(post("/api/v1/writer/1/webBook/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(RegisterWebBookChapterRequestDto.builder()
                                                                                                      .episode(1)
                                                                                                      .name("제목1")
                                                                                                      .description("설명1")
                                                                                                      .build())
                        )).andExpect(status().isBadRequest())
                        .andDo(print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}