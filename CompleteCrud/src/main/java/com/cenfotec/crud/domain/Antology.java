package com.cenfotec.crud.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Antology {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;	
	
	private String name;
	
	private String text;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="anthology")
	private Set<Article> articles;

	/*public Antology() {
		
		this.articles = new HashSet<Article>();
	}*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> particles) {
		this.articles.addAll(particles);
	}

	public void setArticle(Article particle) {
		this.articles.add(particle);
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
