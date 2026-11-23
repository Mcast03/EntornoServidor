package com.ejemplo.estopa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejemplo.estopa.model.Cancion;
import com.ejemplo.estopa.model.Estilo;
import com.ejemplo.estopa.repository.CancionRepository;

public class CancionExitosServiceImpl implements ICancionService{
	@Autowired
	CancionRepository cancionRepository;  
	
	@Override
	public List<Cancion> getAll() {
		List<Cancion> hits = new ArrayList<>();
		
		for (Cancion cancion : cancionRepository.findAll()) {
			if (cancion.getReproducciones()>50) {
				hits.add(cancion);
			}
		}
		
		return hits;
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
