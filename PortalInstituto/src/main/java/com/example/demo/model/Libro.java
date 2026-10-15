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
	
	public Libro() {}
	
	
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

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setNumeroEjemplares(Integer numeroEjemplares) {
		this.numeroEjemplares = numeroEjemplares;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Libro [autor=" + autor + ", id=" + id + ", titulo=" + titulo + ", numeroEjemplares=" + numeroEjemplares
				+ ", genero=" + genero + "]";
	}
	
	
}
