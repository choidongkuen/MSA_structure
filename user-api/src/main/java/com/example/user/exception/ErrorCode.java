package com.example.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    WRITER_NOT_FOUND("일치하는 작가가 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    READER_NOT_FOUND("일치하는 독자가 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR("내부 서버 에러입니다.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String errorMessage;
    private final HttpStatus httpStatus;
}
