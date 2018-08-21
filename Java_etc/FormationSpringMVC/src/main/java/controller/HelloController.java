package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(@RequestParam(value="username", required=false, defaultValue="Nom par défaut") String username, Model model) {
		
		model.addAttribute("nomUtilisateur", username);
		
		return "hello";
	}
	
}
