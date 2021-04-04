package com.jaxrs.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaxrs.entity.Article;
import com.jaxrs.repository.Articlerepository;

@Service
public class ArticleService implements IArticleservice{
	@Autowired
	private Articlerepository crudrepository;
	
	@Override
	public Article getArticleById(long articleId) {
		Article obj = crudrepository.findById(articleId).get();
		return obj;
	}	
	@Override
	public List<Article> getAllArticles(){
		List<Article> list = new ArrayList<>();
		crudrepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	@Override
	public synchronized boolean addArticle(Article article){
	        List<Article> list = crudrepository.findByTitleAndCategory(article.getTitle(), article.getCategory()); 	
                  if (list.size() > 0) {
    	          return false;
                } else {
                	crudrepository.save(article);
    	          return true;
                }
	}
	@Override
	public void updateArticle(Article article) {
		crudrepository.save(article);
	}
	@Override
	public void deleteArticle(int articleId) {
		crudrepository.delete(getArticleById(articleId));
	}
	
	

}
