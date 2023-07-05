package com.example.payment.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WebBookChapterPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long webBookChapterId;

    private Long readerId;

    private Long writerId;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "is_refunded")
    private Boolean isRefunded;

    private LocalDateTime refundedAt;

    private LocalDateTime createdAt;
}
