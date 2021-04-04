package com.jaxrs.service;
import java.util.List;

import com.jaxrs.entity.Article;

public interface IArticleservice {

	
	List<Article> getAllArticles();
    Article getArticleById(long articleId);
    boolean addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
}
