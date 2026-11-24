package com.example.gimnasio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gimnasio.model.Ejercicio;
import com.example.gimnasio.model.Grupo;
import com.example.gimnasio.repository.EjercicioRepository;

@Service
public class EjercicioConPesoServiceImpl implements IEjercicioService {

	@Autowired
	EjercicioRepository ejercicioRepository;

	@Override
	public List<Ejercicio> getAll() {
		List<Ejercicio> conPeso = new ArrayList<>();

		for (Ejercicio ejercicio : ejercicioRepository.findAll()) {
			if (ejercicio.isConMaquina()) {
				conPeso.add(ejercicio);
			}
		}

		return conPeso;
	}

	@Override
	public Ejercicio getById(int id) {
		return ejercicioRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		ejercicioRepository.deleteById(id);
	}

	@Override
	public void save(Ejercicio ejercicio) {
		ejercicioRepository.save(ejercicio);
	}
	
	@Override
	public List<Ejercicio> filtrarPorGrupoAndMaquina(Grupo grupo, boolean maquina) {
		if(grupo == null && !maquina) {
			return ejercicioRepository.findAll();
		}
		
		if(grupo == null) {
			return ejercicioRepository.conMaquinaTrue();
		}
		
		if(!maquina) {
			return ejercicioRepository.getByGrupo(grupo);
		}
		
		return ejercicioRepository.getByGrupoAndConMaquinaTrue(grupo);
	}


}
