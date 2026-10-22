package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class BienvenidaService  implements IBienvenidaService{
	public String dimeHola() {
		return "Hola";
	}
	
	public String dimeAdios() {
		return "Adios";
	}
	
	public String dimeHola(String nombre) {
		return "Hola "+ nombre;
	}

	public String dimeAdios(String nombre) {
		return "Adios "+ nombre;
	}
}
