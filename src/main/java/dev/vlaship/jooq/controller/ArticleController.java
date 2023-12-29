package dev.vlaship.jooq.controller;

import dev.vlaship.jooq.default_schema.tables.records.ArticlesRecord;
import dev.vlaship.jooq.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetExchange("/articles")
    public ResponseEntity<ArticlesRecord> getArticles() {
        return ResponseEntity.ok(articleService.getArticles());
    }

}
