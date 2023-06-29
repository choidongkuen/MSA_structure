package com.example.webbook.domain.repository;


import com.example.webbook.domain.entity.WebBookChapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebBookChapterRepository extends JpaRepository<WebBookChapter, Long> {
}
