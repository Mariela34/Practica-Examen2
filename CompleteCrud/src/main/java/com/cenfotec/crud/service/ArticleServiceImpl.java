package com.cenfotec.crud.service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cenfotec.crud.repo.*;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.cenfotec.crud.domain.Antology;
import com.cenfotec.crud.domain.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository repoArticle;


    public ArticleServiceImpl() {
    }
	

	public Article save(Article article) {
		return repoArticle.save(article);
	}

	

	@Override
	public Optional<Article> get(Long id) {
		// TODO Auto-generated method stub
		return repoArticle.findById(id);
	}



	@Override
	public List<Article> articles(Long idAntology) {
		// TODO Auto-generated method stub
		return null;
	}

}
