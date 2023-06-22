package com.example.monolithic.domain.repository;

import com.example.monolithic.domain.entity.Reader;
import com.example.monolithic.domain.entity.ReaderWebBookPayment;
import com.example.monolithic.domain.entity.WebBookChapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReaderWebBookPaymentRepository extends JpaRepository<ReaderWebBookPayment, Long> {
    List<ReaderWebBookPayment> findAllByReaderAndWebBookChapter(Reader reader, WebBookChapter webBookChapter);
}
