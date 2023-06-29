package com.example.user.service;

import com.example.user.client.WebBookClient;
import com.example.user.client.dto.RegisterWebBookChapterRequestClientDto;
import com.example.user.client.dto.RegisterWebBookRequestClientDto;
import com.example.user.domain.entity.Writer;
import com.example.user.domain.repository.WriterRepository;
import com.example.user.dto.RegisterWebBookChapterRequestDto;
import com.example.user.dto.RegisterWebBookRequestDto;
import com.example.user.dto.RegisterWriterRequestDto;
import com.example.user.exception.ErrorCode;
import com.example.user.exception.writer.WriterException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class WriterService {

    private final WriterRepository writerRepository;

    private final WebBookClient webBookClient;

    @Transactional
    public Long registerWriter(RegisterWriterRequestDto request) {
        if (this.writerRepository.countByEmail(request.getEmail()) > 0) {
            throw new WriterException(ErrorCode.WRITER_NOT_FOUND);
        }
        return this.writerRepository.save(request.toEntity())
                                    .getId();
    }

    @Transactional
    public Long registerWebBook(Long writerId, RegisterWebBookRequestDto request) {

        checkWriterExist(writerId);

        return this.webBookClient.registerWebBook(
                RegisterWebBookRequestClientDto.builder()
                                               .title(request.getTitle())
                                               .description(request.getDescription())
                                               .writer(writerId)
                                               .build()
        );
    }

    @Transactional
    public Long registerWebBookChapter(Long writerId, Long webBookId, RegisterWebBookChapterRequestDto request) {

        checkWriterExist(writerId);

        return this.webBookClient.registerWebBookClient(
                webBookId,
                RegisterWebBookChapterRequestClientDto.builder()
                                                      .title(request.getTitle())
                                                      .price(request.getPrice())
                                                      .episode(request.getEpisode())
                                                      .description(request.getDescription())
                                                      .build()
        );
    }

    private void checkWriterExist(Long writerId) {
        Writer writer = this.writerRepository.findById(writerId)
                                             .orElseThrow(() -> new WriterException(ErrorCode.WRITER_NOT_FOUND));
    }
}
