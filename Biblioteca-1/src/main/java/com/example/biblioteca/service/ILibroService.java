package com.example.biblioteca.service;

import java.util.List;

import com.example.biblioteca.model.Genero;
import com.example.biblioteca.model.Libro;

public interface ILibroService {
	List<Libro> getAll();
	void deletedById(Integer id);
	Libro getById(Integer id);
	void save(Libro libro);
	List<Libro> filtrarByGeneroAndDisponible(Genero genero, boolean disponible);
}
