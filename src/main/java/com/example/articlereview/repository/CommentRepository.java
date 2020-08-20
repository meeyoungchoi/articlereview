package com.example.articlereview.repository;

import com.example.articlereview.entity.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository  extends CrudRepository<Comment, Long> {
    @Override
    List<Comment> findAll();
}
