package com.vahid.encyclopedia.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Article {

    @Id
    String id;
    String title;
    String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
