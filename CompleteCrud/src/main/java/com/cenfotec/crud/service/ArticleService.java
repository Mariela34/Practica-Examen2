package com.cenfotec.crud.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.crud.domain.Article;

public interface ArticleService {
	public Article save(Article article);
	public List<Article> articles(Long idAntology);
	public Optional<Article> get(Long id);
}
