package com.ejemplo.estopa.service;

import java.util.List;

import com.ejemplo.estopa.model.Cancion;
import com.ejemplo.estopa.model.Estilo;

public interface ICancionService{
	List<Cancion> getAll();
	Cancion getById(int id);
	void deleteById(int id);
	void save(Cancion cancion);
	List<Cancion> filtrarEstilosAnsSingleTrue(Estilo estilo, boolean single);
}
