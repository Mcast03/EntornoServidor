package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Animal;


public class Animales {

	private List<Animal> animales;

	public Animales() {
		animales = new ArrayList<>();
		animales.add(new Animal("Perro", 5, 150.0, "Mamífero", false));
		animales.add(new Animal("Gato", 8, 90.0, "Mamífero", true));
		animales.add(new Animal("Conejo", 12, 35.5, "Mamífero", false));
		animales.add(new Animal("Hámster", 20, 12.0, "Mamífero", true));
		animales.add(new Animal("Periquito", 15, 25.0, "Ave", false));
		animales.add(new Animal("Canario", 10, 30.0, "Ave", true));
		animales.add(new Animal("Pez payaso", 30, 18.5, "Pez", false));
		animales.add(new Animal("Pez dorado", 50, 4.0, "Pez", true));
		animales.add(new Animal("Tortuga", 6, 45.0, "Reptil", false));
		animales.add(new Animal("Iguana", 3, 120.0, "Reptil", false));
	}

	public List<Animal> dameTodos() {
		return animales;
	}

	public Animal damePorId(int id) {
		for (Animal animal : animales) {
			if (animal.getId() == id) {
				return animal;
			}
		}
		return null;
	}

	public List<Animal> dameFiltrados(String tipo, boolean soloOferta) {
		List<Animal> filtrados = new ArrayList<>();
		for (Animal animal : animales) {
			boolean tipoVale = tipo == null || tipo.isEmpty() || tipo.equals(animal.getTipo());
			boolean ofertaVale = !soloOferta || animal.isOferta();
			if (tipoVale && ofertaVale) {
				filtrados.add(animal);
			}
		}
		return filtrados;
	}

	public List<String> dameTipos() {
		List<String> tipos = new ArrayList<>();
		for (Animal animal : animales) {
			if (!tipos.contains(animal.getTipo())) {
				tipos.add(animal.getTipo());
			}
		}
		return tipos;
	}


}