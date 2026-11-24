package com.example.gimnasio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gimnasio.model.Ejercicio;
import com.example.gimnasio.model.Grupo;
import com.example.gimnasio.repository.EjercicioRepository;

@Service
public class EjercicioServiceImpl implements IEjercicioService{

	private final EjercicioConPesoServiceImpl ejercicioConPesoServiceImpl;
	@Autowired
	EjercicioRepository ejercicioRepository;

	EjercicioServiceImpl(EjercicioConPesoServiceImpl ejercicioConPesoServiceImpl) {
		this.ejercicioConPesoServiceImpl = ejercicioConPesoServiceImpl;
	}
	
	@Override
	public List<Ejercicio> getAll() {
		return ejercicioRepository.findAll();
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
