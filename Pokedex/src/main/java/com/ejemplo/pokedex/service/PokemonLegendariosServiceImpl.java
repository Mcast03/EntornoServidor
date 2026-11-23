package com.ejemplo.pokedex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.pokedex.model.Pokemon;
import com.ejemplo.pokedex.model.Tipo;
import com.ejemplo.pokedex.repository.PokedexRepository;

@Service
public class PokemonLegendariosServiceImpl implements IPokedexService{
	@Autowired
	PokedexRepository pokedexRepository;
	
	@Override
	public Pokemon getById(int id) {
		return pokedexRepository.findById(null).orElse(null);
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
		List<Pokemon> legendarios = new ArrayList<>();
		
		for (Pokemon pokemon : pokedexRepository.findAll()) {
			if(pokemon.isLegendario()) {
				legendarios.add(pokemon);
			}
		}
		
		return legendarios;
	}

	@Override
	public List<Pokemon> filtrarPokemons(Tipo tipo, boolean legendario) {
		if(tipo==null && !legendario) {
			return pokedexRepository.findAll();
		}
		
		if(tipo==null) {
			pokedexRepository.LegendarioTrue();
		}
		
		if(!legendario) {
			pokedexRepository.getByTipo(tipo);
		}
		return pokedexRepository.getByTipoAndLegendarioTrue(tipo, legendario);
	}

}