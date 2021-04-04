package com.jaxrs.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class ArticleInfo {
	
	@JsonInclude(Include.NON_NULL)
	private long articleid;
	
	@JsonInclude(Include.NON_NULL)
	private String title;
	
	@JsonInclude(Include.NON_NULL)
    private String category;

	
	
	public long getArticleid() {
		return articleid;
	}

	public void setArticleid(long articleid) {
		this.articleid = articleid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	

}
