package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController{
	Random rm = new Random();
	
	public List<String> creadorDeProvervios(){	
	List <String> provervios = new ArrayList<>();
	provervios.add("«El mejor momento para plantar un árbol era hace 20 años. El segundo mejor momento es ahora.»");
	provervios.add("«Si quieres ir rápido, ve solo. Si quieres llegar lejos, ve acompañado.»");
	provervios.add("«Cae siete veces, levántate ocho.»");
	provervios.add("«La confianza en sí mismo es el primer secreto del éxito.»");
	provervios.add("«Un viaje de mil millas comienza con un solo paso.»");
	provervios.add("«Cuando los elefantes luchan, es la hierba la que sufre.»");
	provervios.add("«No importa lo lejos que hayas viajado por un mal camino, siempre puedes dar la vuelta.»");
	provervios.add("«Muchos pocos hacen un mucho.»");
	provervios.add("«Conoce todas las reglas, domina cómo romper una.»");
	provervios.add("«Ten paciencia: lo amargo se endulzará con el tiempo.»");
	
	return provervios;
	}
	
	public String seleccionadorProvervio() {
		Integer numero = rm.nextInt(9);
		List <String> provervios = creadorDeProvervios();
		return provervios.get(numero);
	}
	
	@GetMapping("/home") 
	public String m(Model model) {
		model.addAttribute("provervio", seleccionadorProvervio());
		return "home";
	}

}
