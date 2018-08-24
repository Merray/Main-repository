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

import com.example.demo.videoclub.model.Adherent;
import com.example.demo.videoclub.model.Civilite;
import com.example.demo.videoclub.repositories.AdherentRepository;

@Controller
@RequestMapping("/adherent")
public class AdherentController {

	@Autowired
	private AdherentRepository adherentRepository;

	@RequestMapping("/")
	public String list(Model model) {
		model.addAttribute("adherents", adherentRepository.findAll());
		return "adherent/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Integer id) {
		adherentRepository.deleteById(id);
		return "redirect:/adherent/";
	}

	@RequestMapping("/update")
	public String update(Model model, @RequestParam(name = "id") Integer id) {
		Optional<Adherent> opt = adherentRepository.findById(id);
		if (opt.isPresent()) {
			return goEdit(opt.get(), model);
		} else {
			return goEdit(new Adherent(), model);
		}
	}

	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute("adherent") Adherent adherent, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(adherent, model);
		} else {
			adherentRepository.save(adherent);
			return "redirect:/adherent/";
		}
	}

	@RequestMapping("/create")
	public String create(Model model) {
		return goEdit(new Adherent(), model);
	}

	private String goEdit(Adherent adherent, Model model) {
		model.addAttribute("adherent", adherent);
		model.addAttribute("civilite", Civilite.values());
		return "adherent/update";
	}

	@RequestMapping("/createbis")
	public ModelAndView createbis(Model model) {
		return goEditbis(new Adherent(), model);
	}

	// data-toggle="modal" data-target="#modalFormulaire"
	private ModelAndView goEditbis(Adherent adherent, Model model) {
		ModelAndView mv = new ModelAndView("adherent/list#modalFormulaire");
		mv.getModelMap().addAttribute("adherent", adherent);
		mv.getModelMap().addAttribute("civilite", Civilite.values());
		return mv;
	}
}
