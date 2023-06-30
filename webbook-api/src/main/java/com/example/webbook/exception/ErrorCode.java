package com.example.webbook.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {


    WEB_BOOK_NOT_FOUND("일치하는 웹 소설 정보가 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    WEB_BOOK_CHAPTER_NOT_FOUND("일치하는 웹 소설 챕터 정보가 존재하지 않습니다.", HttpStatus.NOT_FOUND);


    private final String errorMessage;

    private final HttpStatus httpStatus;
}
