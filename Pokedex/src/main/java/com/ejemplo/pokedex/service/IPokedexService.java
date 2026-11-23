package com.ejemplo.pokedex.service;

import java.util.List;

import com.ejemplo.pokedex.model.Pokemon;
import com.ejemplo.pokedex.model.Tipo;

public interface IPokedexService{
	Pokemon getById(int id);
	void save(Pokemon pokemon);
	void deleteById(int id);
	List<Pokemon> getAll();
	List<Pokemon> filtrarPokemons(Tipo tipo, boolean legendario);
}
