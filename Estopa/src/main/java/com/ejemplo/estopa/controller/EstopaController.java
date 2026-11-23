package com.ejemplo.estopa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.estopa.model.Cancion;
import com.ejemplo.estopa.model.Estilo;
import com.ejemplo.estopa.service.ICancionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/estopa")
public class EstopaController {
	@Autowired
	@Qualifier("cancionServiceImpl")
	ICancionService cancionService;

	@GetMapping("/lista")
	public String lista(Model model, @RequestParam (defaultValue = "false") boolean single, @RequestParam (required = false) Estilo estilo) {
		model.addAttribute("estilo", estilo.values());
		model.addAttribute("estiloElegido", estilo);
		model.addAttribute("single", single);
		model.addAttribute("canciones", cancionService.filtrarEstilosAnsSingleTrue(estilo, single));
		return "/cancion/lista";
	}

	@GetMapping("/ficha/{id}")
	public String ficha(Model model, @PathVariable int id) {
		model.addAttribute("cancion", cancionService.getById(id));
		return "/cancion/ficha";
	}

	@PostMapping("/borrar/{id}")
	public String borrar(@PathVariable int id) {
		cancionService.deleteById(id);
		return "redirect: /estopa/lista";
	}

	@GetMapping("/nueva")
	public String nueva(Model model, Estilo estilo, Cancion cancion) {
		model.addAttribute("cancion", cancion);
		model.addAttribute("estilo", estilo.values());
		return "/cancion/formulario";
	}

	@GetMapping("/editar/{id}")
	public String editar(Model model, Estilo estilo, @PathVariable int id) {
		model.addAttribute("estilo", estilo.values());
		model.addAttribute("cancion", cancionService.getById(id));
		return "/cancion/formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result, Model model,
			Estilo estilo) {

		if (result.hasErrors()) {
			model.addAttribute("estilo", estilo.values());
			model.addAttribute("cancion", cancion);
			return "/cancion/formulario";
		}

		cancionService.save(cancion);
		return "redirect: /estopa/lista";
	}
}
