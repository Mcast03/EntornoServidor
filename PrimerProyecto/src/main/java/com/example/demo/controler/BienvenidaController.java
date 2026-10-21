package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.BienvenidaService;

@Controller
@RequestMapping("/bienvenido")
public class BienvenidaController {

	//@Autowired
	private BienvenidaService bienvenidaService;

	@GetMapping("/adios/{nombre}")
	public String bienvenidaAdios(Model model, @PathVariable String nombre) {
		model.addAttribute("texto", bienvenidaService.dimeAdios(nombre));
		return "/home";
	}

	@GetMapping("/adios")
	public String bienvenidaAdios(Model model) {
		model.addAttribute("texto", bienvenidaService.dimeAdios());
		return "/home";
	}
}
