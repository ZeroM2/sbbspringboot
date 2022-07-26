package com.mysite.sbb.Article.dao;


import com.mysite.sbb.Article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);

    boolean existsByTitle(String title);

    boolean existByBody(String body);

    List<Article> findByBody(String body);

    boolean existsByTitleAndBody(String title, String body);

    List<Article> findBytitleAndBody(String title, String body);
}