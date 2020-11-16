package com.cenfotec.crud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.event.TableColumnModelListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cenfotec.crud.service.*;
import com.cenfotec.crud.domain.*;

@Controller
public class AntologyController {

	@Autowired
	AntologyService anthologyService;
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("date", new Date());
		return "index";
	}
	
	@RequestMapping(value = "/insertar",  method = RequestMethod.GET)
	public String insertarPage(Model model) {
		model.addAttribute(new Antology());
		return "insertar";
	}	
	
	@RequestMapping(value = "/insertar",  method = RequestMethod.POST)
	public String insertarAction(Antology antology, BindingResult result, Model model) {
		anthologyService.save(antology);
		return "index";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("anthologies",anthologyService.getAll());
		return "listar";
	}
	
	@RequestMapping(value = "/perfil/anthology/{id}",  method = RequestMethod.GET)
	public String getAntology(@PathVariable("id") Optional<Long> id,Antology antology, BindingResult result, Model model) {
		Optional<Antology> antOptional = anthologyService.get(id.get());

		if (antOptional.isPresent()) {
			model.addAttribute("anthology",antOptional.get());
			return "perfilAnthology";
        }
		return "404";
	}

	@RequestMapping(value = "/verArticulos/{id}")
	public String getListArticles(@PathVariable("id") Long id, Model model) {
		Optional<Antology> antOptional = anthologyService.get(id);

		if (antOptional.isPresent()) {
			model.addAttribute("anthology", antOptional.get());
			return "verArticulos";
		}
		return "404";
	}
	
	@RequestMapping(value = "/edit/anthology/{id}",  method = RequestMethod.GET)
	public String getEditAntology(@PathVariable("id") Optional<Long> id,Antology antology, BindingResult result, Model model) {
		Optional<Antology> antOptional =anthologyService.get(id.get());
		if (antOptional.isPresent()) {
			model.addAttribute("anthology", antOptional.get());
			return "editar";
        } else {
        	model.addAttribute("anthology",new Antology());
        }	
		return "404";
	}
	
	
	@RequestMapping(value = "/edit/anthology/{id}",  method = RequestMethod.POST)
	public String editarAntologyAction(@PathVariable("id") Long id,Antology antology, BindingResult result, Model model) {
		anthologyService.update(antology);
		Optional<Antology> antOptional =anthologyService.get(id);
		model.addAttribute("anthology",antOptional.get());
		
		return "perfilAnthology";
	}
	
	
	@RequestMapping(value = "/article/insertar/{anthology_id}", method = RequestMethod.GET)
	public String getInsertArticle(@PathVariable("anthology_id") Optional<Long> id, Model model) {
		Optional<Antology> antOptional = anthologyService.get(id.get());
		
		Article art = new Article();
		
		if(antOptional.isPresent()) {
			art.setAnthology(antOptional.get());
			model.addAttribute("antology",antOptional.get());
			model.addAttribute("article", art);
			return "agregarArticulo";
		}
		
		
	
		return "404";
		
	}
	
	
	@RequestMapping(value = "/article/insertar/{anthology_id}", method = RequestMethod.POST)
	public String agregarArticulo(@PathVariable("anthology_id") Long id, Article article, Antology antology, BindingResult result, Model model) {
			
		Optional<Antology> antOptional = anthologyService.get(id);
		
		if(antOptional.isPresent()) {
			Antology ant =antOptional.get();
			article.setAnthology(ant);
			articleService.save(article);
			ant.getArticles().add(article);
			anthologyService.addArticle(ant);
			
			model.addAttribute("anthology",ant);
			model.addAttribute("articles", ant.getArticles());
			return "perfilAnthology";
		}
		return "errorArticulo";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
