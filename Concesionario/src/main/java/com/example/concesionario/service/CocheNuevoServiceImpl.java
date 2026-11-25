package com.example.concesionario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.concesionario.model.Coche;
import com.example.concesionario.model.Combustible;
import com.example.concesionario.repository.CocheRepository;

@Service
public class CocheNuevoServiceImpl implements ICocheService{
	
	@Autowired
	CocheRepository cocheRepository;
	
	@Override
	public List<Coche> getAll() {
		List<Coche> cochesNuevos = new ArrayList <>();
		
		for (Coche coche : cocheRepository.findAll()) {
			if(coche.isNuevo()) {
				cochesNuevos.add(coche);
			}
		}
		
		return cochesNuevos;
	}

	@Override
	public Coche getById(int id) {
		return cocheRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		cocheRepository.deleteById(id);
	}

	@Override
	public void save(Coche coche) {
		cocheRepository.save(coche);
	}
	
	@Override
	public List<Coche> filtrarByCombustibleAndPrecio(Combustible combustible, double precio) {
		if(combustible == null && precio == 0) {
			return cocheRepository.findAll();
		}
		
		if(combustible == null) {
			List<Coche> cocheEnPrecio = new ArrayList <>();
			  for(Coche coche : cocheRepository.findAll()){
				  if(coche.getPrecio()>= precio) {
					  cocheEnPrecio.add(coche);
				  }
			  }
			 return cocheEnPrecio;
		}
		
		if(precio == 0) {
			return cocheRepository.getByCombustible(combustible);
		}
		
		List<Coche> cocheEnPrecio = new ArrayList <>();
		
		for(Coche coche : cocheRepository.findAll()) {
			if(coche.getCombustible().equals(combustible) && coche.getPrecio()>= precio) {
				cocheEnPrecio.add(coche);
			}
		}
		
		return cocheEnPrecio;
	}
}
