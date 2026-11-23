package com.ejemplo.estopa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.estopa.model.Cancion;
import com.ejemplo.estopa.model.Estilo;

public interface CancionRepository extends JpaRepository<Cancion, Integer>{
	List<Cancion> singleTrue();
	List<Cancion> getByEstilo(Estilo estilo);
	List<Cancion> getByEstiloAndSingleTrue(Estilo estilo);
}
