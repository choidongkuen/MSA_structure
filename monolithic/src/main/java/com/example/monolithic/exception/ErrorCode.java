package com.example.monolithic.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    WRITER_NOT_FOUND("일치하는 작가가 존재하지 않습니다."),
    WRITER_ALREADY_EXIST("이미 존재하는 작가입니다."),
    WEB_BOOK_NOT_FOUND("일치하는 웹소설 정보가 존재하지 않습니다."),
    INTER_SERVER_ERROR("내부 서버 에러입니다.");

    private final String errorMessage;
}
