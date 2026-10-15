package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Libro;

@Controller
@RequestMapping("/libros")
public class BibliotecaController {

	private static List<Libro> biblioteca = generadorLibros();

	private static List<Libro> generadorLibros(){
		List<Libro> libros = new ArrayList<>();
		
		libros.add(new Libro("Gabriel García Márquez", "Cien años de soledad", 5, "Novela",1));
		libros.add(new Libro("Miguel de Cervantes", "Don Quijote de la Mancha", 8, "Novela",2));
		libros.add(new Libro("Isabel Allende", "La casa de los espíritus", 3, "Novela",3));
		libros.add(new Libro("Antoine de Saint-Exupéry", "El principito", 10, "Fantasía",4));
		libros.add(new Libro("J. R. R. Tolkien", "El Hobbit", 7, "Fantasía",5));
		libros.add(new Libro("Mary Shelley", "Frankenstein", 2, "Fantasía",6));
		libros.add(new Libro("George Orwell", "1984", 6, "Ciencia ficción",7));
		libros.add(new Libro("Ray Bradbury", "Fahrenheit 451", 5, "Ciencia ficción",8));
		libros.add(new Libro("Carlos Ruiz Zafón", "La sombra del viento", 4, "Misterio",9));
		libros.add(new Libro("Agatha Christie", "Asesinato en el Orient Express", 6, "Misterio",10));
		
		return libros;
	}
	
	@GetMapping("/lista")
	public String biblioteca(Model model) {
		model.addAttribute("libros", biblioteca);
		return "biblioteca";
	}
	
	public Libro filtrarLibro(Integer id) {
		
		for(Libro libro : generadorLibros()) {
			if (libro.getId() == id) {
				return libro;
			}
		}
		
		return null;
	}
	
	@GetMapping("/id/{id}")
	public String filtrado(Model model, @PathVariable Integer id) {
		
		model.addAttribute("libro", filtrarLibro(id));
		return "filtro";
	}
	
	
	
	public List<Libro> filtroGenero(String genero){
		List <Libro> filtrogenero = new ArrayList<>();
		
		for(Libro libro : generadorLibros()) {
			if (libro.getGenero().equals(genero)) {
				filtrogenero.add(libro);
			}
		}
		return filtrogenero;
	}
	
	
	@GetMapping("/genero/{genero}")
	public String filtroGeneros(Model model, @PathVariable String genero){
		
		model.addAttribute("libros", filtroGenero(genero));
		return "biblioteca";
	}

	@GetMapping("/formulario")
	public String introducirLibro(Model model) {
		model.addAttribute("libro", new Libro());
		return "bibliotecaForm";
	}
	
	public int numeroId() {
	    int id = 1;
	    while (existeId(id)) {
	        id++;
	    }
	    return id;
	}

	private boolean existeId(int id) {
	    for (Libro libro : biblioteca) {
	        if (libro.getId() == id) {
	            return true;
	        }
	    }
	    return false;
	}
	
	@PostMapping("/lista")
	public String obtenerLibro(Model model, Libro libro) {
		libro.setId(numeroId());
		biblioteca.add(libro);
		System.out.println(libro);
		return "redirect:/libros/lista";
	}
}
