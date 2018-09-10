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

import com.example.demo.videoclub.model.Adherent;
import com.example.demo.videoclub.model.view.JsonViews;
import com.example.demo.videoclub.repositories.AdherentRepository;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/rest/adherent")
public class AdherentRestController {

	@Autowired
	private AdherentRepository adherentRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Adherent>> findAll() {
		return new ResponseEntity<>(adherentRepository.findAll(), HttpStatus.OK);
	}

	@JsonView(JsonViews.AdherentWithArticles.class)
	@GetMapping(path = { "/article" })
	public ResponseEntity<List<Adherent>> findAllWithArticle() {
		return new ResponseEntity<>(adherentRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = { "/", "" })
	public ResponseEntity<Void> createAdherent(@Valid @RequestBody Adherent adherent, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			adherentRepository.save(adherent);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/adherent/{id}").buildAndExpand(adherent.getId()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Adherent> findById(@PathVariable(name = "id") Integer id) {
		Optional<Adherent> opt = adherentRepository.findById(id);
		ResponseEntity<Adherent> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Adherent> update(@Valid @RequestBody Adherent adherent, BindingResult br) {
		if (br.hasErrors() || adherent.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Adherent> opt = adherentRepository.findById(adherent.getId());
		if (opt.isPresent()) {
			// update possible
			Adherent adherentEnBase = opt.get();
			adherentEnBase.setPrenom(adherent.getPrenom());
			adherentEnBase.setNom(adherent.getNom());
			adherentEnBase.setDateNaissance(adherent.getDateNaissance());
			adherentEnBase.setAdresse(adherent.getAdresse());
			adherentEnBase.setCivilite(adherent.getCivilite());
			adherentRepository.save(adherentEnBase);
			return new ResponseEntity<Adherent>(adherentEnBase, HttpStatus.OK);
		} else {
			// pas d'adherent
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<Adherent> opt = adherentRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			adherentRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
