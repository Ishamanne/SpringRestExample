package com.jaxrs.controller;
import java.util.ArrayList;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jaxrs.entity.Article;
import com.jaxrs.exception.ArticleException;
import com.jaxrs.exception.ArticleNotFoundException;


import com.jaxrs.service.IArticleservice;


@RestController
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ArticleController {
	@Autowired
	private IArticleservice as;
	
	
	@GetMapping(value="article/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArticleInfo> getArticleById(@PathVariable("id") Integer id)throws Exception{
		if(id==1) {
			throw new ArticleNotFoundException((int) id);
		}else if(id==2){
			throw new SQLException("SQLException, id="+id);
		}else if(id==3){
			throw new IOException("IOException, id="+id);
		}
		ArticleInfo ob = new ArticleInfo();
		BeanUtils.copyProperties(as.getArticleById(id), ob);
		if(ob == null) {
			throw new ArticleException("Article Does Not Exist");
		}
		return new ResponseEntity<ArticleInfo>(ob, HttpStatus.OK);
		
	}
	
	@GetMapping(value= "articles", produces= { MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ArticleInfo>> getAllArticles() {
		List<ArticleInfo> responseArticleList = new ArrayList<>();
		List<Article> articleList = as.getAllArticles();
		for (int i = 0; i < articleList.size(); i++) {
			ArticleInfo ob = new ArticleInfo();
		    BeanUtils.copyProperties(articleList.get(i), ob);
		    responseArticleList.add(ob);    
		}
		return new ResponseEntity<List<ArticleInfo>>(responseArticleList, HttpStatus.OK);
	}
	
	//create
	@PostMapping(value="article", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> addArticle(@RequestBody ArticleInfo articleinfo, UriComponentsBuilder builder){
		Article article = new Article();
		BeanUtils.copyProperties(articleinfo, article);
		boolean flag = as.addArticle(article);
		if(flag == false) {
			return new ResponseEntity<Void> (HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleid()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	//update
	
	@PutMapping(value="article", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArticleInfo> updateArticle(@RequestBody ArticleInfo articleInfo){
		Article article = new Article();
		BeanUtils.copyProperties(articleInfo, article);
		
		as.updateArticle(article);
		
		ArticleInfo ob = new ArticleInfo();
		BeanUtils.copyProperties(article,ob);
		
		return new ResponseEntity<ArticleInfo>(ob,HttpStatus.OK);
		
		
	}
	
	//delete by id
	@DeleteMapping(value= "darticle/{id}", produces ={MediaType.APPLICATION_JSON_VALUE} ) 
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) throws ArticleException{
		Article ob = new Article();
		try {
		ob = as.getArticleById(id);
		}
		catch(Exception e) {
		
					throw new ArticleException("Article Does Not Exist");
				
		}
		as.deleteArticle(id);
		
		return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
	}

}
