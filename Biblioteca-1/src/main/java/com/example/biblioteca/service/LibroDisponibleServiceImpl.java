package com.example.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.repository.LibroRepository;

public class LibroDisponibleServiceImpl implements ILibroService{
	
	@Autowired
	LibroRepository libroRepository;

	@Override
	public List<Libro> getAll() {
		List<Libro> libros = new ArrayList<>(); 
		for (Libro libro : libroRepository.findAll()) {
			if(libro.isDisponible()) {
				libros.add(libro);
			}
		}
		
		return libros;
	}

	@Override
	public void deletedById(Integer id) {
		libroRepository.deleteById(id);
		
	}

	@Override
	public Libro getById(Integer id) {
		return libroRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Libro libro) {
		libroRepository.save(libro);
		
	}

}
