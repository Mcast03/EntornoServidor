package com.example.demo.model;

public class Animal {
	private static int nextId;
	private int id;
	private String especie;
	private int cantidad;
	private String tipo;
	private boolean oferta;
	private double precio;
	
	public Animal(String especie, int cantidad, double precio, String tipo, boolean oferta) {
		id = nextId++;
		this.especie = especie;
		this.cantidad = cantidad;
		this.precio = precio;
		this.tipo = tipo;
		this.oferta = oferta;
	}

	
	//getters y setters
	
	public static int getNextId() {
		return nextId;
	}

	public static void setNextId(int nextId) {
		Animal.nextId = nextId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Animal [id=" + id + ", especie=" + especie + ", cantidad=" + cantidad + ", tipo=" + tipo + ", oferta="
				+ oferta + ", precio=" + precio + "]";
	}
}