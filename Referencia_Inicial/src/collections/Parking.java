package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parking {
	private String nombre;
	private Integer totalPlazas;
	private List<Coche> coches;

	public Parking(Integer plazas, String nombre) {
		this.coches = new ArrayList<>();
		this.nombre = nombre;
		this.totalPlazas = plazas;
	}

	public boolean entraCoche(Coche c) {
		if (this.coches.size() == totalPlazas) {
			return false;
		}

		else {
			this.coches.add(c);
			return true;
		}
	}

	public boolean saleCoche(Coche c) {

		if (!this.coches.contains(c) || this.coches.isEmpty()) {
			return false;
		}

		else {
			this.coches.remove(c);
			return true;
		}

	}

	public boolean saleCocheAleatorio() {
		if (this.coches.isEmpty()) {
			return false;
		}

		else {
			Random rm = new Random();
			Integer coche = rm.nextInt(this.coches.size() - 1);
			this.coches.remove(coche);
			return true;
		}
	}

	public boolean vaciarParking() {
		if (this.coches.isEmpty())
			return false;

		else {
			for (Coche car : this.coches) {
				this.coches.remove(car);
			}
			return true;
		}
	}
	
	public void reportParking() {
		System.out.println("Listado de coches"
				+ "\n----------------"
				+ "\nParking: " + this.nombre);
		for(Coche car : this.coches) {
			System.out.println("\t"+car);
		}
		
		System.out.println("Total coches: " + this.coches.size() + ", plazas libres: " + (this.totalPlazas - this.coches.size()));
	}
}
