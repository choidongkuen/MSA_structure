package com.example.monolithic.domain.repository;

import com.example.monolithic.domain.entity.WebBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebBookRepository extends JpaRepository<WebBook, Long> {
}
