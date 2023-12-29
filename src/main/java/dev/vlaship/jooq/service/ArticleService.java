package dev.vlaship.jooq.service;

import dev.vlaship.jooq.default_schema.tables.records.ArticlesRecord;
import dev.vlaship.jooq.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticlesRecord getArticles() {
        return articleRepository.getArticles();
    }

}
