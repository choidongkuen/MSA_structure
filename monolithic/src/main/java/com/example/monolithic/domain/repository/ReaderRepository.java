package com.example.monolithic.domain.repository;

import com.example.monolithic.domain.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
