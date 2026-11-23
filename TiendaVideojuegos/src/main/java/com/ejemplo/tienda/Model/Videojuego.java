package com.ejemplo.tienda.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class Videojuego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank @Size(min = 2, max = 80)
	private String titulo;
	
	@Min(value=1970)
	private int anio;
	
	@Column(name="copias_vendidas") @PositiveOrZero
	private long copiasVendidas;
	
	@Column(name= "en_oferta")
	private boolean enOferta;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Plataforma plataforma;

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

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public long getCopiasVendidas() {
		return copiasVendidas;
	}

	public void setCopiasVendidas(long copiasVendidas) {
		this.copiasVendidas = copiasVendidas;
	}

	public boolean isEnOferta() {
		return enOferta;
	}

	public void setEnOferta(boolean enOferta) {
		this.enOferta = enOferta;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
	
	
}
