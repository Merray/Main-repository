package com.example.demo.web.controller;

import java.util.Optional;

import javax.validation.Valid;

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

@Controller
@RequestMapping("/article")
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
		return new ModelAndView("article/list","articles", articleRepository.findAll());
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Integer id) {
		articleRepository.deleteById(id);
		return "redirect:/article/";
	}
	
	@RequestMapping("/createdvd")
	public ModelAndView createDvd() {
		return goEdit(new Dvd());
	}
	
	@RequestMapping("/createblueray")
	public ModelAndView create() {
		return goEdit(new Blueray());
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam(name = "id") Integer id) {
		Optional<Article> opt = articleRepository.findById(id);
		if(opt.isPresent()) {
			return goEdit(opt.get());
		} else {
			return new ModelAndView("redirect:/article/");
		}
	}
	
	@RequestMapping("/savedvd")
	public ModelAndView saveDvd(@Valid @ModelAttribute("article") Dvd dvd, BindingResult br) {
		return save(dvd, br);
	}
	
	@RequestMapping("/saveblueray")
	public ModelAndView saveBlueray(@Valid @ModelAttribute("article") Blueray blueray, BindingResult br) {
		return save(blueray, br);
	}
	
	@RequestMapping("/save")
	public ModelAndView save(Article article, BindingResult br) {
		if (article.getEmprunteur() != null && article.getEmprunteur().getId() == null) {
			article.setEmprunteur(null);
		}
		if(br.hasErrors()) {
			return goEdit(article);
		} else {
			articleRepository.save(article);
			return new ModelAndView("redirect:/article/");
		}
	}
	
	private ModelAndView goEdit(Article article) {
		ModelAndView mv = new ModelAndView("article/update");
		mv.getModelMap().addAttribute("article", article);
		mv.getModelMap().addAttribute("adherents",adherentRepository.findAll());
		return mv;
	}
}
