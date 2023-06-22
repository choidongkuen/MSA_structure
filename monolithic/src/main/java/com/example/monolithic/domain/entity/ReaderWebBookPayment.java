package com.example.monolithic.domain.entity;

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
@Table(name = "reader_web_book_payment")
public class ReaderWebBookPayment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private WebBookChapter webBookChapter;

    @ManyToOne(fetch = FetchType.LAZY)
    private Reader reader;

    @Column(name = "payment_amount")
    private Integer paymentAmount;
}
