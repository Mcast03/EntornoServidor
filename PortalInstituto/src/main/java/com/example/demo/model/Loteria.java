package com.example.demo.model;


public class Loteria {
	private String nombre;
	private Integer numGanadores;
	private Integer numBolas;
	
	public Loteria(String pais, Integer numGanadores, Integer numBolas) {
		this.nombre = pais;
		this.numBolas = numBolas;
		this.numGanadores = numGanadores;
	}

	
	//getters
	public String getNombre() {
		return nombre;
	}

	public Integer getNumGanadores() {
		return numGanadores;
	}

	public Integer getNumBolas() {
		return numBolas;
	}
	
	
}
