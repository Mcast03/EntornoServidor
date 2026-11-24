package com.example.gimnasio.service;

import java.util.List;

import com.example.gimnasio.model.Ejercicio;
import com.example.gimnasio.model.Grupo;

public interface IEjercicioService {
	List<Ejercicio> getAll();
	Ejercicio getById(int id);
	void deleteById(int id);
	void save(Ejercicio ejercicio);
	List <Ejercicio> filtrarPorGrupoAndMaquina(Grupo grupo, boolean maquina);
}
