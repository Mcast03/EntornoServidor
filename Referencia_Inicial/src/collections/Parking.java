package collections;

import java.util.ArrayList;
import java.util.List;

public class Parking {
	private String nombre;
	private int totaPlazas;
	private List <Coche> coches;
	
	public Parking() {
		this.coches = new ArrayList<>();
	}
}
