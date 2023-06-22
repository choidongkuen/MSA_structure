package com.example.monolithic.service;

import com.example.monolithic.domain.entity.WebBook;
import com.example.monolithic.domain.repository.ReaderRepository;
import com.example.monolithic.domain.repository.WebBookChapterRepository;
import com.example.monolithic.domain.repository.WebBookRepository;
import com.example.monolithic.dto.RegisterReaderRequestDto;
import com.example.monolithic.dto.WebBookChapterDto;
import com.example.monolithic.dto.WebBookDto;
import com.example.monolithic.exception.ErrorCode;
import com.example.monolithic.exception.reader.ReaderException;
import com.example.monolithic.util.Encryptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final WebBookRepository webBookRepository;
    private final WebBookChapterRepository webBookChapterRepository;
    private final Encryptor encryptor;

    @Transactional
    public Long registerReader(RegisterReaderRequestDto request) {

        try {
            request.setRegistrationNumber(encryptor.encrypt(request.getRegistrationNumber()));
        } catch (Exception e) {
            throw new ReaderException(ErrorCode.INTER_SERVER_ERROR);
        }
        return this.readerRepository.save(request.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<WebBookDto> getWebBookList() {
        return this.webBookRepository.findAll()
                                     .stream().map(WebBookDto::from)
                                     .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<WebBookChapterDto> getWebBookChapterList(Long webBookId) {
        WebBook webBook = this.webBookRepository.findById(webBookId)
                                                .orElseThrow(() -> new ReaderException(ErrorCode.WEB_BOOK_NOT_FOUND));


        return this.webBookChapterRepository.findAllByWebBook(webBook)
                                            .stream().map(WebBookChapterDto::from)
                                            .collect(Collectors.toList());
    }
}
