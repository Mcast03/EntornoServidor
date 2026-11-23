package com.ejemplo.cine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.cine.model.Pelicula;
import com.ejemplo.cine.repository.PeliculaRepository;

@Service
public class PeliculasCarteleraServiceImpl implements IPeliculaService{

	@Autowired
	PeliculaRepository peliculaRepository;

	@Override
	public List<Pelicula> dameTodas() {
		List<Pelicula> peliculasEnCartelera = new ArrayList<>();
		
		for (Pelicula pelicula : peliculaRepository.findAll()) {
			if(pelicula.getEnCartelera()) {
				peliculasEnCartelera.add(pelicula);
			}
		}
		return  peliculasEnCartelera;
	}

	@Override
	public Pelicula damePorId(Integer id) {
		return peliculaRepository.findById(id).orElse(null);
	}

	@Override
	public Pelicula guardar(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Override
	public void borrarPorId(Integer id) {
		peliculaRepository.existsById(id);
	}

}
