package com.example.demo.model;

public class Taller {
	private int id;
	private String nombre;
	private int plazas;
	private static int nextId = 1;

	public Taller(String nombre, int plazas) {
		this.id = this.nextId++;
		this.nombre = nombre;
		this.plazas = plazas;
	}

	// getters y setters
	public int getId() {
		return id;
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
		return "Taller [id=" + id + ", nombre=" + nombre + ", plazas=" + plazas + "]";
	}

}
