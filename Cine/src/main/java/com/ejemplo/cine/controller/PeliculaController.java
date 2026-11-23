package com.ejemplo.cine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplo.cine.model.Genero;
import com.ejemplo.cine.model.Pelicula;
import com.ejemplo.cine.service.IPeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
	@Autowired
	@Qualifier("peliculasServiceImpl")
	private IPeliculaService peliculaService;
	
	@GetMapping("")
	public String lista(Model model) {
		model.addAttribute("peliculas", peliculaService.dameTodas());
		return"peliculas/lista";
	}
	
	@GetMapping("/{id}")
	public String ficha(@PathVariable int id, Model model){
		model.addAttribute("pelicula", peliculaService.damePorId(id));
		return "peliculas/ficha";
	}
	
	@PostMapping("/borrar/{id}")
	public String borrar(@PathVariable int id) {
		peliculaService.borrarPorId(id);
		return "redirect:/peliculas";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		model.addAttribute("pelicula", peliculaService.damePorId(id));
		return"peliculas/editar";
	}
	
	@GetMapping("/nueva")
	public String nueva(Model model) {
		model.addAttribute("pelicula", new Pelicula());
		model.addAttribute("genero", Genero.values());
		return "pelicula/formulario";
	}
}
