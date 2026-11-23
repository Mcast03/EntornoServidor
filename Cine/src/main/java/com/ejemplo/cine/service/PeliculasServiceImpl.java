package com.ejemplo.cine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.cine.model.Pelicula;
import com.ejemplo.cine.repository.PeliculaRepository;

@Service
public class PeliculasServiceImpl implements IPeliculaService{
	
	@Autowired
	PeliculaRepository peliculaRepository;

	@Override
	public List<Pelicula> dameTodas() {
		return peliculaRepository.findAll();
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
		peliculaRepository.deleteById(id);
	}

}
