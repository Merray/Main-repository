package com.example.demo.web.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.videoclub.model.Adherent;
import com.example.demo.videoclub.model.Article;
import com.example.demo.videoclub.model.Blueray;
import com.example.demo.videoclub.model.Dvd;
import com.example.demo.videoclub.model.views.JsonViews;
import com.example.demo.videoclub.repositories.ArticleRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/article")
public class ArticleRestController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = {"/", ""})
	public ResponseEntity<List<Article>> findAll() {
		return new ResponseEntity<List<Article>>(articleRepository.findAll(), HttpStatus.OK);
	}
	
//	@JsonView(JsonViews.AdherentWithArticles.class)
//    @GetMapping(path = { "/article", "" })
//    public ResponseEntity<List<Adherent>> findAllwithArticle() {
//        return new ResponseEntity<>(adherentRepository.findAll(), HttpStatus.OK);
//    }
	@JsonView(JsonViews.Common.class)
	@PostMapping(path= {"/dvd"})
	public ResponseEntity<Void> createDvd(@Valid @RequestBody Dvd dvd, BindingResult br, UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if(br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			articleRepository.save(dvd);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/article/{id}").buildAndExpand(dvd.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	@JsonView(JsonViews.Common.class)
	@PostMapping(path= {"/blueray"})
	public ResponseEntity<Void> createBlueRay(@Valid @RequestBody Blueray blueRay, BindingResult br, UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if(br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			articleRepository.save(blueRay);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/article/{id}").buildAndExpand(blueRay.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	
	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Article> findById(@PathVariable(name = "id") Integer id) {
		Optional<Article> opt = articleRepository.findById(id);
		ResponseEntity<Article> response = null;
		if(opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(),HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@PutMapping(path = {"/dvd"})
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Article> updateDvd(@Valid @RequestBody Dvd dvd, BindingResult br) {
		ResponseEntity<Article> response = null;
		if(br.hasErrors() || dvd.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Article> opt = articleRepository.findById(dvd.getId());
		if(opt.isPresent()) {
			Dvd dvdEnBase = (Dvd) opt.get();
			dvdEnBase.setNbDisques(dvd.getNbDisques());
			dvdEnBase.setBonus(dvd.getBonus());
			dvdEnBase.setEmprunteur(dvd.getEmprunteur());
			return new ResponseEntity<Article>(dvdEnBase, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PutMapping(path = {"/blueray"})
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Article> updateBlueRay(@Valid @RequestBody Blueray blueRay, BindingResult br) {
		ResponseEntity<Article> response = null;
		if(br.hasErrors() || blueRay.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Article> opt = articleRepository.findById(blueRay.getId());
		if(opt.isPresent()) {
			Blueray dvdEnBase = (Blueray) opt.get();
			dvdEnBase.setNbDisques(blueRay.getNbDisques());
			dvdEnBase.setTroisD(blueRay.getTroisD());
			dvdEnBase.setEmprunteur(blueRay.getEmprunteur());
			return new ResponseEntity<Article>(dvdEnBase, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name="id") Integer id) {
		Optional<Article> opt = articleRepository.findById(id);
		ResponseEntity<Void> response = null;
		if(opt.isPresent()) {
			articleRepository.delete(opt.get());
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
