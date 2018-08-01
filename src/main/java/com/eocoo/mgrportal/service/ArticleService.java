package com.eocoo.mgrportal.service;

import com.eocoo.mgrportal.domain.Article;
import com.eocoo.mgrportal.domain.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(Long id) {
        Optional<Article> op = articleRepository.findById(id);
        return op.get();
    }

    public void addArticle(Article article) {
        articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    public void modArticle(Article article) {
        articleRepository.save(article);
    }
}
