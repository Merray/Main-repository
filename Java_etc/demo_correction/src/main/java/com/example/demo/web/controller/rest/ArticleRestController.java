package com.example.demo.web.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.videoclub.model.Article;
import com.example.demo.videoclub.model.Blueray;
import com.example.demo.videoclub.model.Dvd;
import com.example.demo.videoclub.model.view.JsonViews;
import com.example.demo.videoclub.repositories.ArticleRepository;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/rest/article")
public class ArticleRestController {

	@Autowired
	private ArticleRepository ArticleRepository;

	// @RequestMapping(value="/", method=RequestMethod.GET)
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Article>> findAll() {
		return new ResponseEntity<>(ArticleRepository.findAll(), HttpStatus.OK);
	}

	// request body corps de la requête
	@PostMapping(path = { "/bluray", "" })
	public ResponseEntity<Void> createBlueray(@Valid @RequestBody Blueray bluray, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ArticleRepository.save(bluray);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("rest/bluray/{id}").buildAndExpand(bluray.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	// request body corps de la requête
	@PostMapping(path = { "/dvd", "" })
	public ResponseEntity<Void> createDvd(@Valid @RequestBody Dvd dvd, BindingResult br, UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ArticleRepository.save(dvd);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("rest/dvd/{id}").buildAndExpand(dvd.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Article> update(@Valid @RequestBody Article Article, BindingResult br) {
		if (br.hasErrors() || Article.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Article> opt = ArticleRepository.findById(Article.getId());
		if (opt.isPresent()) {
			// update possible
			Article ArticleEnBase = opt.get();
			ArticleEnBase.setNbDisques(Article.getNbDisques());

			if (Article.getClass().getSimpleName() == "Dvd") {

				((Dvd) ArticleEnBase).setBonus(((Dvd) Article).getBonus());
			} else {

				((Blueray) ArticleEnBase).setTroisD(((Blueray) Article).getTroisD());
			}

			ArticleRepository.save(ArticleEnBase);
			return new ResponseEntity<Article>(ArticleEnBase, HttpStatus.OK);
		} else {
			// pas d'Article
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Article> findById(@PathVariable(name = "id") Integer id) {
		Optional<Article> opt = ArticleRepository.findById(id);
		ResponseEntity<Article> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<Article> opt = ArticleRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			ArticleRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
