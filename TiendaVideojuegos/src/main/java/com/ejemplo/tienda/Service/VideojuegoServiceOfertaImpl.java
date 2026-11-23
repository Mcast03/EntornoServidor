package com.ejemplo.tienda.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.tienda.Model.Plataforma;
import com.ejemplo.tienda.Model.Videojuego;
import com.ejemplo.tienda.Repository.VideojuegoRepository;

@Service
public class VideojuegoServiceOfertaImpl implements IVideojuegoService{

	@Autowired
	VideojuegoRepository videojuegoRepository;
	
	@Override
	public List<Videojuego> darTodos() {
		List <Videojuego> juegosOferta = new ArrayList<>();
		for (Videojuego j : videojuegoRepository.findAll()) {
			if(j.isEnOferta()) {juegosOferta.add(j);}
		}
		return juegosOferta;
	}

	@Override
	public Videojuego darPorId(int id) {
		return videojuegoRepository.findById(id).orElse(null);
	}

	@Override
	public void borrarPorId(int id) {
		videojuegoRepository.deleteById(id);
		
	}

	@Override
	public void save(Videojuego juego) {
		videojuegoRepository.save(juego);
		
	}
	
	@Override
	public List<Videojuego> dameFiltradas(Plataforma plataforma, boolean enOferta) {
		if (plataforma == null && !enOferta) {
			return videojuegoRepository.findAll();
		}

		if (plataforma == null) {
			return videojuegoRepository.findByEnOfertaTrue();
		}

		if (!enOferta) {
			return videojuegoRepository.findByPlataforma(plataforma);
		}

		return videojuegoRepository.findByPlataformaAndEnOfertaTrue(plataforma);
	}

}
