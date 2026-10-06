package com.example.demo.model;

public class Taller {
	private int id;
	private String nombre;
	private String tipo;
	private int plazas;
	private static int nextId = 1;

	public Taller(String nombre, int plazas, String tipo) {
		this.id = this.nextId++;
		this.nombre = nombre;
		this.plazas = plazas;
		this.tipo = tipo;
	}

	// getters y setters
	public int getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPlazas() {
		return plazas;
	}

	public static int getNextId() {
		return nextId;
	}

	//toString
	@Override
	public String toString() {
		return "Taller [id=" + id + ", nombre=" + nombre + ", plazas=" + plazas + ", tipo=" + tipo +"]";
	}

}
