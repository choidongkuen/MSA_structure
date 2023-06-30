package com.example.webbook.domain.entity;

import com.example.user.dto.GetWebBookChaptersResponseDto;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "episode", nullable = false)
    private Integer episode;

    @Column(name = "name")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    private WebBook webBook;

    public GetWebBookChaptersResponseDto from() {
        return GetWebBookChaptersResponseDto.builder()
                                            .episode(episode)
                                            .title(title)
                                            .description(description)
                                            .price(price)
                                            .build();
    }
}

