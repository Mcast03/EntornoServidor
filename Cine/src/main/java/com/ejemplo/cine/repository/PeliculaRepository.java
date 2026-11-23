package com.ejemplo.cine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.cine.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{

}
