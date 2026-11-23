package com.ejemplo.tienda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.tienda.Model.Plataforma;
import com.ejemplo.tienda.Model.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {
	List<Videojuego> findByEnOfertaTrue();
	List<Videojuego> findByPlataforma(Plataforma plataforma);
	List<Videojuego> findByPlataformaAndEnOfertaTrue(Plataforma plataforma);
}
