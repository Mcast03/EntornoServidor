package com.example.demo.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Animal;
import com.example.demo.utils.Animales;


@Service
@Primary
public class AnimalServiceImpl implements IAnimalService {

	private final Animales animales = new Animales();

	@Override
	public List<Animal> dameTodos() {
		return animales.dameTodos();
	}

	@Override
	public Animal damePorId(int id) {
		return animales.damePorId(id);
	}

	@Override
	public List<Animal> dameFiltrados(String tipo, boolean soloOferta) {
		return animales.dameFiltrados(tipo, soloOferta);
	}

	@Override
	public List<String> dameTipos() {
		return animales.dameTipos();
	}
}