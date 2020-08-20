package com.example.articlereview.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Entity
public class Article extends BaseTime {//질문 테이블이 만들어잊는 이유 가 @Entity때문인가?

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;



    @Builder
    public Article(Long id, String title, String content , LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
      super.setCreatedAt(createdAt);//질문?
       super.setUpdatedAt(updatedAt);
    }


//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                ", createdAt='" + super.getCreatedAt()
//                '}';
//    }
}
