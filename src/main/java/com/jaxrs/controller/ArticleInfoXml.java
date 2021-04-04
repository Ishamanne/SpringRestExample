package com.jaxrs.controller;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName="article", namespace="com.jaxrs")
public class ArticleInfoXml {
	@JacksonXmlProperty(localName = "articleId")
	private long articleId;
	
	@JacksonXmlProperty(localName="title")
    private String title;
@JacksonXmlProperty(localName="category")
    private String category;
public long getArticleId() {
	return articleId;
}
public void setArticleId(long articleId) {
	this.articleId = articleId;
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
