package com.example.monolithic.service;

import com.example.monolithic.domain.entity.Reader;
import com.example.monolithic.domain.entity.ReaderWebBookPayment;
import com.example.monolithic.domain.entity.WebBook;
import com.example.monolithic.domain.entity.WebBookChapter;
import com.example.monolithic.domain.repository.ReaderRepository;
import com.example.monolithic.domain.repository.ReaderWebBookPaymentRepository;
import com.example.monolithic.domain.repository.WebBookChapterRepository;
import com.example.monolithic.domain.repository.WebBookRepository;
import com.example.monolithic.dto.CreateReaderWebBookPaymentRequestDto;
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
    private final ReaderWebBookPaymentRepository readerWebBookPaymentRepository;
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

    /*
     독자가 결제한 웹 소설 챕터만 조회
    */
    @Transactional(readOnly = true)
    public List<WebBookChapterDto> getWebBookChapterList(Long readerId, Long webBookChapterId) {

        Reader reader = this.readerRepository.findById(readerId)
                                             .orElseThrow(() -> new ReaderException(ErrorCode.READER_NOT_FOUND));

        WebBookChapter webBookChapter = this.webBookChapterRepository.findById(webBookChapterId)
                                                                     .orElseThrow(() -> new ReaderException(ErrorCode.WEB_BOOK_CHAPTER_NOT_FOUND));

        return this.readerWebBookPaymentRepository.findAllByReaderAndWebBookChapter(reader, webBookChapter)
                                                  .stream()
                                                  .map(e -> WebBookChapterDto.from(e.getWebBookChapter()))
                                                  .collect(Collectors.toList());


    }

    /*
       독자의 웹 소설 챕터 결제
     */
    @Transactional
    public Long createReaderPaymentWebBookChapter(Long readerId, CreateReaderWebBookPaymentRequestDto request) {

        Reader reader = this.readerRepository.findById(readerId)
                                             .orElseThrow(() -> new ReaderException(ErrorCode.READER_NOT_FOUND));

        WebBookChapter webBookChapter = this.webBookChapterRepository.findById(request.getWebBookChapterId())
                                                                     .orElseThrow(() -> new ReaderException(ErrorCode.WEB_BOOK_CHAPTER_NOT_FOUND));

        if (!webBookChapter.getPrice().equals(request.getPrice())) {
            throw new ReaderException(ErrorCode.INTER_SERVER_ERROR);
        }

        return this.readerWebBookPaymentRepository.save(
                ReaderWebBookPayment.builder()
                                    .webBookChapter(webBookChapter)
                                    .reader(reader)
                                    .paymentAmount(request.getPrice())
                                    .build()
        ).getId();
    }
}
