package com.ejemplo.cine.service;

import java.util.List;

import com.ejemplo.cine.model.Pelicula;

public interface IPeliculaService {
	List <Pelicula> dameTodas();
	Pelicula damePorId(Integer id);
	Pelicula guardar(Pelicula pelicula);
	void borrarPorId(Integer id);
}
