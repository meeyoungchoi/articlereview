package com.example.articlereview.repository;

import com.example.articlereview.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Override
    List<Article> findAll();
}
