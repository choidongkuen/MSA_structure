package com.example.webbook.domain.repository;


import com.example.webbook.domain.entity.WebBook;
import com.example.webbook.domain.entity.WebBookChapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebBookChapterRepository extends JpaRepository<WebBookChapter, Long> {
    List<WebBookChapter> findByWebBook(WebBook webBook);
}
