package com.cenfotec.crud.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.crud.domain.Antology;
import com.cenfotec.crud.domain.Article;
import com.cenfotec.crud.repo.AntologyRepository;

@Service
public class AntologyServiceImpl implements AntologyService {

	@Autowired
	AntologyRepository repo;
	

	 public AntologyServiceImpl() {
    }

	
	@Override
	public void save(Antology antology) {
		repo.save(antology);
	}

	@Override
	public Optional<Antology> get(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<Antology> find(String name) {
		return repo.findByNameContaining(name);
	}

	@Override
	public List<Antology> getAll() {
		return repo.findAll();
	}
	
	
	@Override
	public Antology getAntology(long id) {
		return repo.getOne(id);
		
	}

	@Override
	public void update(Antology antology) {
		// TODO Auto-generated method stub

		repo.save(antology);
	}
	
	@Override
	public Antology addArticle(Antology antology) {
		Antology ant = new Antology();
		ant = repo.save(antology);
		
		//ant = repo.getOne(antology.getId());
		return ant;
	}
	
	
}
