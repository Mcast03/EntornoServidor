package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Animal;

public interface IAnimalService {
	
	List<Animal> dameTodos();
	List<Animal> dameFiltrados(String tipo, boolean soloOferta);
	List<String> dameTipos();
	Animal damePorId(int id);

}
