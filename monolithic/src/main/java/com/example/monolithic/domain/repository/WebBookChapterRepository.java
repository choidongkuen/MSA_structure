package com.example.monolithic.domain.repository;

import com.example.monolithic.domain.entity.WebBookChapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebBookChapterRepository extends JpaRepository<WebBookChapter, Long> {
}
