package com.vahid.encyclopedia.controller;

import com.vahid.encyclopedia.model.Article;
import com.vahid.encyclopedia.service.ArticleService;

import lombok.RequiredArgsConstructor;

import javax.annotation.security.RolesAllowed;

import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("articles")
@RequiredArgsConstructor
public class ArticleController {

    public final ArticleService articleService;
    
    @GetMapping()
    public Flux<Article> get() {
        return articleService.get();
    }

    @GetMapping("{id}")
    public Mono<Article> get(@PathVariable String id) {
        return articleService.get(id);
    }

    @PostMapping()
    public Mono<Article> save(@RequestBody Article article) {
        return articleService.save(article);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Mono<Void> delete(@PathVariable String id) {
        return articleService.delete(id);
    }

}
