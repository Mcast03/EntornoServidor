package com.example.concesionario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.concesionario.model.Coche;
import com.example.concesionario.model.Combustible;
import com.example.concesionario.service.ICocheService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/concesionario")
public class ConcesionarioController {

	@Autowired
	@Qualifier("cocheServiceImpl")
	ICocheService cocheService;
	
	@GetMapping("/lista")
	public String lista(Model model, @RequestParam (required = false) Combustible combustible, @RequestParam (defaultValue = "0") double precio) {
		model.addAttribute("coches", cocheService.filtrarByCombustibleAndPrecio(combustible, precio));
		model.addAttribute("combustible", combustible);
		model.addAttribute("combustible", combustible.values());
		model.addAttribute("precio", precio);
		return "/coches/lista";
	}
	
	@GetMapping("/ficha/{id}")
	public String ficha(Model model, @PathVariable int id) {
			model.addAttribute("coche", cocheService.getById(id));
		return "/coches/ficha";
	}
	
	@PostMapping("/borrar/{id}")
	public String borrar(@PathVariable int id) {
		cocheService.deleteById(id);
		return "redirect: /concesionario/lista";
	}
	
	@GetMapping("/crear")
	public String crear(Model model, Coche coche, Combustible combustible) {
		model.addAttribute("coche", coche);
		model.addAttribute("combustible", combustible.values());
		return "/coches/formulario";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(Model model, Combustible combustible, @PathVariable int id) {
		model.addAttribute("coche", cocheService.getById(id));
		model.addAttribute("combustible", combustible.values());
		return "/coches/formulario";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Coche coche, BindingResult resultado, Model model, Combustible combustible) {
		
		if(resultado.hasErrors()) {
			model.addAttribute("combustible", combustible.values());
			model.addAttribute("coche", coche);
			return "/coches/formulario";
		}
		
		cocheService.save(coche);
		return "redirect: /concesionario/lista";
	}
}
