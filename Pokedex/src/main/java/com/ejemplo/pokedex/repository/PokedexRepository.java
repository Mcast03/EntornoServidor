package com.ejemplo.pokedex.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ejemplo.pokedex.model.Pokemon;
import com.ejemplo.pokedex.model.Tipo;

public interface PokedexRepository extends JpaRepository<Pokemon, Integer>{
	List<Pokemon> getByTipo(Tipo tipo);
	List<Pokemon> getByTipoAndLegendarioTrue(Tipo tipo, boolean legendario);
	List<Pokemon> LegendarioTrue();
}
