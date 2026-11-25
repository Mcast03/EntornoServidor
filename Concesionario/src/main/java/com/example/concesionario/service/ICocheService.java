package com.example.concesionario.service;

import java.util.List;

import com.example.concesionario.model.Coche;
import com.example.concesionario.model.Combustible;

public interface ICocheService {
	List<Coche> getAll();
	Coche getById(int id);
	void deleteById(int id);
	void save(Coche coche);
	List<Coche> filtrarByCombustibleAndPrecio(Combustible combustible, double precio);
}
