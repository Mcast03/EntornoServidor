package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Persona;

@Controller

public class PersonaController {

	@GetMapping("/persona/form")
	public String mostrarFormularioEnBlanco(Model model) {
		model.addAttribute("persona", new Persona());
		return "persona/form";
	}
	
	@PostMapping("/persona/form")
	public String enviarFormularioConDatos(Model model, Persona persona) {
		System.out.println(persona);
		return "persona/ok";
	}
	
}