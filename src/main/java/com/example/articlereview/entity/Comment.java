package com.example.articlereview.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment  extends BaseTime{ //질문
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =  20, nullable = false)
    private String author;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
}
