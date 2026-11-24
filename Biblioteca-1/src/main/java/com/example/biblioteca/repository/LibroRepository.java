package com.example.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.model.Genero;
import com.example.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{
	List<Libro> getByGenero(Genero genero);
	List<Libro> disponibleTrue();
	List<Libro> getByGeneroAndDisponibleTrue(Genero genero);
}
