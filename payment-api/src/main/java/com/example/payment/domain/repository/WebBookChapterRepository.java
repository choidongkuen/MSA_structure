package com.example.payment.domain.repository;

import com.example.payment.domain.entity.WebBookChapterPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebBookChapterRepository extends JpaRepository<WebBookChapterPayment, Long> {
}
