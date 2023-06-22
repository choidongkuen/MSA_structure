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
@Table(name = "writer_web_book_payment")
public class WriterWebBookPayment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private WebBookChapter webBookChapter;

    @OneToOne(fetch = FetchType.LAZY)
    private ReaderWebBookPayment readerWebBookPayment;
    
    @Column(name = "is_withdraw")
    private Boolean isWithdraw;

    @Column(name = "payment_amount")
    private Integer paymentAmount;
}
