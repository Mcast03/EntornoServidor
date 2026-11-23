package com.ejemplo.cine.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private Integer anio;
	private Long recaudacion;
	@Column(name = "en_cartelera")
	private Boolean enCartelera;
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	public Pelicula() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Long getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(Long recaudacion) {
		this.recaudacion = recaudacion;
	}

	public Boolean getEnCartelera() {
		return enCartelera;
	}

	public void setEnCartelera(Boolean enCartera) {
		this.enCartelera = enCartera;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	
}
