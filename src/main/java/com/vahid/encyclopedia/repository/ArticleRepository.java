package com.vahid.encyclopedia.repository;

import com.vahid.encyclopedia.model.Article;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ReactiveCrudRepository<Article, String>{

}