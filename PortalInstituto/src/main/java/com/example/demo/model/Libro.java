package com.example.demo.model;

public class Libro {
	private String autor;
	private Integer id;
	private String titulo;
	private Integer numeroEjemplares;
	private String genero;
	
	public Libro(String autor, String titulo, Integer numero, String genero, Integer id) {
		this.autor = autor;
		this.titulo = titulo;
		this.numeroEjemplares = numero;
		this.genero = genero;
		this.id = id;
	}
	
	
	//getters
	public Integer getId() {
		return id;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public Integer getNumeroEjemplares() {
		return numeroEjemplares;
	}

	public String getGenero() {
		return genero;
	}
}
