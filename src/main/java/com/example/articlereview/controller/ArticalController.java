package com.example.articlereview.controller;

import com.example.articlereview.entity.Article;
import com.example.articlereview.form.ArticleForm;
import com.example.articlereview.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ArticalController {
    //@Autowired
    //질문 @RequiredArgsConstructor가 ArticleRepository객체를 자동으로 만들어주는가?
    //@Autowried와 같은기능?
    //final을 붙이는 이유?
    private final ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        return "/articles/list";
    }

    @GetMapping("/articles/new")
    public String newArticle() {
        return "articles/new";
    }

    @PostMapping("/articles/new")
    public String create(ArticleForm articleForm) {
        log.info(articleForm.toString());

        Article article = articleForm.toEntity();
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //질문 article테이블은 리파지토리가 자동으로 만들어주는가?

        return "redirect:/";
    }

    @GetMapping("/articles/show/{id}")
    public String show(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).orElse(null);
        log.info(article.toString());
        model.addAttribute("article", article);
        return "articles/show";
    }

    @GetMapping("/articles/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).orElse(null);
        log.info(article.toString());

        model.addAttribute("article", article);
        return "articles/edit";
    }


    @PostMapping("/articles/update/{id}")
    public String update(ArticleForm articleForm) {
        log.info(articleForm.toString());

        Article article = articleForm.toEntity();
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "redirect:/articles/show/{id}";
    }

    @GetMapping("/articles/delete/{id}")
    public String delete(@PathVariable Long id) {
        articleRepository.deleteById(id);
        log.info(id + "번 삭제완료");
        return "redirect:/";
    }
}

