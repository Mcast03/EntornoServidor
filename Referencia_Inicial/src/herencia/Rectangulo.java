package herencia;

public class Rectangulo extends Figura{
	private int base;
	private int altura;
	
	public Rectangulo(String color, int base, int altura) {
		super(color);
		this.base = base;
		this.altura = altura;
	}
	
	public double area() {
		return base*altura;
	}
	
	public double perimetro() {
		return 2*(base+altura);
	}

	@Override
	public String toString() {
		return "Rectangulo [base=" + base + ", altura=" + altura + ", color=" + getColor() + "]";
	}
	
	
}
