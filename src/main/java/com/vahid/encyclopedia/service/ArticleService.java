package com.vahid.encyclopedia.service;

import com.vahid.encyclopedia.model.Article;
import com.vahid.encyclopedia.repository.ArticleRepository;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    
    public Flux<Article> get() {
        return articleRepository.findAll();
    }

    public Mono<Article> get(String id) {
        return articleRepository.findById(id);
    }

    public Flux<Article> save(Flux<Article> articles) {
        return articleRepository.saveAll(articles);
    }

    public Mono<Article> save(Article article) {
        return articleRepository.save(article);
    }

    public Mono<Void> delete(String id) {
        return articleRepository.deleteById(id);
    }

}
