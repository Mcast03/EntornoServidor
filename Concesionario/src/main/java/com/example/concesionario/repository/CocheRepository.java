package com.example.concesionario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.concesionario.model.Coche;
import com.example.concesionario.model.Combustible;

public interface CocheRepository extends JpaRepository<Coche, Integer>{
	List<Coche> getByPrecio(int precio);
	List<Coche> getByCombustible(Combustible combustible);
	List<Coche> getByCombustibleAndPrecio(Combustible combustible, int precio);
}
