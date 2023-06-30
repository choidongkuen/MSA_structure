package com.example.user.domain.repository;

import com.example.user.domain.entity.ReaderWebBookChapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderWebBookRepository extends JpaRepository<ReaderWebBookChapter, Long> {
}
