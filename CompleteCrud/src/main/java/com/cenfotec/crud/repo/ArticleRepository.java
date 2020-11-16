package com.cenfotec.crud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cenfotec.crud.domain.*;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	//List<Article> findAll(Long idAntology);

}
