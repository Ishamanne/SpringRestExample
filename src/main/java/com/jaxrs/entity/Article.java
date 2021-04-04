package com.jaxrs.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="articles")
public class Article implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="articleid")
        private long articleid;  
	@Column(name="title")
        private String title;
	@Column(name="category")	
	private String category;
	
	public Article() {
		
	}
	public Article(long id, String t,String c) {
		this.articleid = id;
		this.title = t;
		this.category = c;
	}
	
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
