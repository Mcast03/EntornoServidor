package collections;

import java.util.Random;

public class Coche {
	private Marca marca;
	private Color color;

	public Coche() {

		Random rm = new Random();
		int indice = rm.nextInt(Marca.values().length);
		this.marca = Marca.values()[indice];
		
		indice = rm.nextInt(Color.values().length);
		this.color = Color.values()[indice];
	}
	
	public Coche(Marca marca, Color color) {
		this.marca = marca;
		this.color = color;
	}
}
