package com.example.articlereview.form;

import com.example.articlereview.entity.Article;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class ArticleForm {

    private Long id;
    private String title;
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Article toEntity() {
        return Article.builder()
                      .id(id)//질문?
                      .title(title)
                      .content(content)
                      .createdAt(createdAt)
                    .updatedAt(updatedAt)
                      .build()
                ;



    }
}
