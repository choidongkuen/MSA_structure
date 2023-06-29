package com.example.webbook.domain.repository;

import com.example.webbook.domain.entity.WebBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebBookRepository extends JpaRepository<WebBook, Long> {
}
