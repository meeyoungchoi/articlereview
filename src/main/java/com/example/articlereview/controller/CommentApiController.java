package com.example.articlereview.controller;

import com.example.articlereview.entity.Comment;
import com.example.articlereview.form.CommentForm;
import com.example.articlereview.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentRepository commentRepository;

    @PostMapping("/api/comments/{articleId}")
    public Long create(@PathVariable Long articleId,
                       @RequestBody CommentForm form) {
        log.info("form: " + form.toString());
        Comment saved = commentRepository.save(form.toEntity());
        log.info("saved: " + saved.toString());
        return saved.getId();
    }

}
