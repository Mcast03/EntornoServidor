package com.ejemplo.pokedex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.pokedex.model.Pokemon;
import com.ejemplo.pokedex.model.Tipo;
import com.ejemplo.pokedex.repository.PokedexRepository;

@Service
public class PokemonServiceImpl implements IPokedexService{
	@Autowired
	PokedexRepository pokedexRepository;
	
	@Override
	public Pokemon getById(int id) {
		return pokedexRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Pokemon pokemon) {
		pokedexRepository.save(pokemon);
		
	}

	@Override
	public void deleteById(int id) {
		pokedexRepository.deleteById(id);
		
	}

	@Override
	public List<Pokemon> getAll() {
		return pokedexRepository.findAll();
	}
	
	@Override
	public List<Pokemon> filtrarPokemons(Tipo tipo, boolean legendario) {
		if(tipo==null && !legendario) {
			return pokedexRepository.findAll();
		}
		
		if(tipo==null && legendario) {
			return pokedexRepository.LegendarioTrue();
		}
		
		if(!legendario) {
			return pokedexRepository.getByTipo(tipo);
		}
		return pokedexRepository.getByTipoAndLegendarioTrue(tipo, legendario);
	}

}
