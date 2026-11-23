package com.example.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.biblioteca.model.Genero;
import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.ILibroService;

@Controller
@RequestMapping("/biblioteca")
public class BibliotecaController {
	
	@Autowired
	@Qualifier("libroServiceImpl")
	ILibroService libroService;
	
	@GetMapping("/lista")
	private String lista(Model model) {
		model.addAttribute("libros", libroService.getAll());
		return "/biblioteca/lista";
	}
	
	
	@PostMapping("/borrar/{id}")
	private String borrar(@PathVariable int id) {
		libroService.deletedById(id);
		return "redirect: /biblioteca/lista";
	}
	
	@GetMapping("/ficha/{id}")
	public String ficha(Model model, @PathVariable int id) {
		model.addAttribute("libro", libroService.getById(id));
		return "/biblioteca/ficha";
	}
	
	@GetMapping("/crear")
	public String crear(Model model, Libro libro, Genero genero) {
		model.addAttribute("generos", genero.values());
		model.addAttribute("libro", new Libro());
		
		return "/biblioteca/formulario";
	}
}
