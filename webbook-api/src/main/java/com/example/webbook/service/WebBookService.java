package com.example.webbook.service;

import com.example.webbook.domain.repository.WebBookRepository;
import com.example.webbook.dto.RegisterWebBookRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class WebBookService {

    private final WebBookRepository webBookRepository;

    public Long registerWebBook(RegisterWebBookRequestDto request) {

        // TODO
        return this.webBookRepository.save(request.toEntity())
                                     .getId();

    }
}
