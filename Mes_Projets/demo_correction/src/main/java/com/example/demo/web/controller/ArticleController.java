package com.example.demo.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.videoclub.model.Article;
import com.example.demo.videoclub.model.Blueray;
import com.example.demo.videoclub.model.Dvd;
import com.example.demo.videoclub.repositories.AdherentRepository;
import com.example.demo.videoclub.repositories.ArticleRepository;

@RequestMapping("/article")
@Controller
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private AdherentRepository adherentRepository;

	@RequestMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/article/");
	}

	@RequestMapping("/")
	public ModelAndView list() {
		return new ModelAndView("article/list", "articles", articleRepository.findAll());
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") Integer id) {
		Optional<Article> opt = articleRepository.findById(id);
		if (opt.isPresent()) {
			return goEdit(opt.get());
		}
		return new ModelAndView("redirect:/article/");
	}

	@RequestMapping("/adddvd")
	public ModelAndView addDvd() {
		return goEdit(new Dvd());
	}

	@RequestMapping("/addbluray")
	public ModelAndView addBluray() {
		return goEdit(new Blueray());
	}

	private ModelAndView goEdit(Article article) {
		ModelAndView modelAndView = new ModelAndView("article/edit", "article", article);
		modelAndView.addObject("adherents", adherentRepository.findAll());
		return modelAndView;
	}

	@RequestMapping("/savedvd")
	public ModelAndView saveDvd(@ModelAttribute("article") Dvd dvd, BindingResult br) {
		return save(dvd, br);
	}

	@RequestMapping("/savebluray")
	public ModelAndView saveBluray(@ModelAttribute("article") Blueray bluray, BindingResult br) {
		return save(bluray, br);
	}

	private ModelAndView save(Article article, BindingResult br) {
		if (article.getEmprunteur() != null && article.getEmprunteur().getId() == null) {
			article.setEmprunteur(null);
		}

		if (br.hasErrors()) {
			return goEdit(article);
		}
		articleRepository.save(article);
		return new ModelAndView("redirect:/article/");
	}
}
