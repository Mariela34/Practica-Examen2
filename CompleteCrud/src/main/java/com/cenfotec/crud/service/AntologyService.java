package com.cenfotec.crud.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.crud.domain.*;


public interface AntologyService {

	public void save(Antology antology);
	public Optional<Antology> get(Long id);
	public List<Antology> getAll();
	public List<Antology> find(String name);
	public Antology getAntology(long id);
	public void update(Antology antology);
	public Antology addArticle(Antology antology);
	
}
