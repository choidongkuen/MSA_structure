package com.example.monolithic.controller;

import com.example.monolithic.dto.RegisterWriterRequestDto;
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

        try {
            this.mockMvc.perform(post("/api/v1/writer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(
                                RegisterWriterRequestDto.builder()
                                                        .name("최동근")
                                                        .email("danaver12@daum.net")
                                                        .build()
                        ))).andExpect(status().isOk())
                        .andDo(print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // when
        // then
    }

//    @Test
//    @DisplayName("작가 등록 컨트롤러 실패")
//    void registerWriterInFailure() {
//        // given
//
//        given(this.writerService.registerWriter(any()))
//                .willThrow(new MethodArgumentNotValidException());
//        // when
//
//        try {
//            this.mockMvc.perform(post("/api/v1/writer")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(this.objectMapper.writeValueAsString(
//                                RegisterWriterRequestDto.builder()
//                                                        .name("")
//                                                        .email("")
//                                                        .build()
//
//                        ))).andExpect(status().isBadRequest())
//                        .andDo(print());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }// then
//    }
}