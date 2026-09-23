package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeControler {
	
	@ModelAttribute(name="titulo")
	public String m() {
		return "Home things";
	}
	
	@GetMapping({"/hola-mundo", "/holamundo"})
	public String holaMundoHandler(Model model) {
		model.addAttribute("titulo", "Home things");
		return "hola";
	}
	

	@GetMapping("/adios-mundo")
	public String adiosMundoHandler() {
		return "adios";
	}
}
