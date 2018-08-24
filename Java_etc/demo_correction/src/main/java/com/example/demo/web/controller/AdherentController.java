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

import com.example.demo.videoclub.model.Adherent;
import com.example.demo.videoclub.model.Civilite;
import com.example.demo.videoclub.repositories.AdherentRepository;

@Controller
@RequestMapping("/adherent")
public class AdherentController {

	@Autowired
	private AdherentRepository adherentRepository;

	@RequestMapping(value = { "/" })
	public String list(Model model) {
		model.addAttribute("adherents", adherentRepository.findAll());
		return "adherent/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Integer id) {
		adherentRepository.deleteById(id);
		return "redirect:/adherent/";
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam(name = "id") Integer id, Model model) {
		Optional<Adherent> opt = adherentRepository.findById(id);
		if (opt.isPresent()) {
			return goEdit(opt.get(), model);
		}
		return goEdit(new Adherent(), model);
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

	@RequestMapping("/add")
	public String add(Model model) {
		return goEdit(new Adherent(), model);
	}

	private String goEdit(Adherent adherent, Model model) {
		model.addAttribute("adherent", adherent);
		model.addAttribute("civilite", Civilite.values());
		return "adherent/edit";
	}
}
