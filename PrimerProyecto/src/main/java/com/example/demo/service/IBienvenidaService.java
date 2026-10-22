package com.example.demo.service;

import org.springframework.context.annotation.Primary;

@Primary
public interface IBienvenidaService{
	String dimeHola();
	String dimeAdios();
	String dimeHola(String nombre);
	String dimeAdios(String nombre);
}
