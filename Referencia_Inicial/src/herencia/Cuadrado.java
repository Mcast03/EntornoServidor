package herencia;

public class Cuadrado extends Figura{
	private int lado;
	
	public Cuadrado(String color, int lado) {
		super(color);
		this.lado = lado;
	}
	
	public double area() {
		return this.lado*this.lado;
	}
	
	public double perimetro() {
		return lado*4;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", color=" + getColor() + "]";
	}
}
