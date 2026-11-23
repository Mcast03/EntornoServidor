package com.ejemplo.estopa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.estopa.model.Cancion;
import com.ejemplo.estopa.model.Estilo;
import com.ejemplo.estopa.repository.CancionRepository;

@Service
public class CancionServiceImpl implements ICancionService{
	@Autowired
	CancionRepository cancionRepository;  
	
	@Override
	public List<Cancion> getAll() {
		return cancionRepository.findAll();
	}

	@Override
	public Cancion getById(int id) {
		return cancionRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		cancionRepository.deleteById(id);
	}

	@Override
	public void save(Cancion cancion) {
		cancionRepository.save(cancion);
	}

	@Override
	public List<Cancion> filtrarEstilosAnsSingleTrue(Estilo estilo, boolean single) {
		if(estilo==null && !single) {
			return cancionRepository.findAll();
		}
		
		if(estilo==null) {
			return cancionRepository.singleTrue();
		}
		
		if(!single) {
			return cancionRepository.getByEstilo(estilo);
		}
		
		return cancionRepository.getByEstiloAndSingleTrue(estilo);
	}

}
