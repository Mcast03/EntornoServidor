package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/home")
public class Controler {
	
	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "Proyecto Propio";
	}
	
	@GetMapping("/hola")
	public String holaMundoController(Model model) {
		return "hola";
	}
	
	@GetMapping("/adios")
	public String adiosMundoController(Model model) {
		return "adios";
	}
}
