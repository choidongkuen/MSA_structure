package com.example.monolithic.domain.repository;

import com.example.monolithic.domain.entity.WebBook;
import com.example.monolithic.domain.entity.WebBookChapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebBookChapterRepository extends JpaRepository<WebBookChapter, Long> {
    List<WebBookChapter> findAllByWebBook(WebBook webBook);
}
