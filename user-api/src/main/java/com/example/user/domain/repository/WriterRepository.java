package com.example.user.domain.repository;

import com.example.user.domain.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer, Long> {

    int countByEmail(String email);
}
