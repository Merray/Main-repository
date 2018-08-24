package com.example.demo.web.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Article;
import com.example.demo.model.BluRay;
import com.example.demo.model.Dvd;
import com.example.demo.repositories.AdherentRepository;
import com.example.demo.repositories.ArticleRepository;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private AdherentRepository adherentRepository;

	@RequestMapping(value = { "/" })
	public String list(Model model) {

		model.addAttribute("articles", articleRepository.findAll());
		return "article/list";

	}

	@RequestMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("article") Article article, BindingResult br) {

		if (br.hasErrors()) {

			return goEdit(article);

		} else {

			articleRepository.save(article);
			return new ModelAndView("redirect:/article/");
		}

	}
	
	@RequestMapping("/savedvd")
	public ModelAndView saveDvd(@Valid @ModelAttribute("article") Dvd article, BindingResult br) {
		
		return save(article, br);
		
	}
	
	@RequestMapping("/savebluray")
	public ModelAndView saveBluRay(@Valid @ModelAttribute("article") BluRay article, BindingResult br) {
		
		return save(article, br);
		
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Integer id, Model model) {

		articleRepository.deleteById(id);
		return "redirect:/article/";
	}

	@RequestMapping("/edit")
	public ModelAndView update(@RequestParam(name = "id") Integer id) {

		Optional<Article> opt = articleRepository.findById(id);

		if (opt.isPresent()) {
			return goEdit(opt.get());
		} else {
			return new ModelAndView("article/list");

		}

	}

	@RequestMapping("/adddvd")
	public ModelAndView addDvd(Model model) {

		return goEdit(new Dvd());

	}

	@RequestMapping("/addbluray")
	public ModelAndView addBluRay() {

		return goEdit(new BluRay());

	}

	private ModelAndView goEdit(Article article) {
		
		
		ModelAndView modelAndView = new ModelAndView("article/edit", "article", article);
		return modelAndView;
	}

}
