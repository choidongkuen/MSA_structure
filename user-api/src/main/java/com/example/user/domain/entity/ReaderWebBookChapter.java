package com.example.user.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReaderWebBookChapter extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reader_id")
    private Long readerId;

    @Column(name = "chapter_id")
    private Long webBookChapterId;

    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "amount")
    private Long paymentAmount;
}
