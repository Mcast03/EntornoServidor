package com.example.gimnasio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gimnasio.model.Ejercicio;
import com.example.gimnasio.model.Grupo;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer>{
	List<Ejercicio> getByGrupo(Grupo grupo);
	List<Ejercicio> conMaquinaTrue();
	List<Ejercicio> getByGrupoAndConMaquinaTrue(Grupo grupo);
}
