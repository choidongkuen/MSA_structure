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
@Table(name = "web_book_chapter")
public class WebBookChapter extends BaseEntity {

    @Column(name = "episode", nullable = false)
    private Integer episode;

    @Column(name = "chapter_name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private WebBook webBook;
}
