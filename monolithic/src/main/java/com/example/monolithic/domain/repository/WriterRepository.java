package com.example.monolithic.domain.repository;

import com.example.monolithic.domain.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer, Long> {

    int countByEmail(String email);
}
