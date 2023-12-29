package dev.vlaship.jooq.repository;

import dev.vlaship.jooq.default_schema.tables.Articles;
import dev.vlaship.jooq.default_schema.tables.records.ArticlesRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final DSLContext dsl;

    public ArticlesRecord getArticles() {
        return dsl
                .fetchOne(Articles.ARTICLES, Articles.ARTICLES.ID.eq(1L));
    }
}
