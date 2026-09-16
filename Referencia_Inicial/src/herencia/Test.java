package herencia;

public class Test {
	public static void main(String[] args) {
		Cuadrado c1 = new Cuadrado("verde", 19);
		Rectangulo r1 = new Rectangulo("azul", 10, 7);
		System.out.println(c1);
		System.out.println(r1);

		Figura f1 = new Cuadrado("amarillo", 10);
		f1.area();
		f1.perimetro();
		System.out.println(f1);

		Figura[] figuras = { new Cuadrado("verde", 7), new Rectangulo("azul", 7, 4), new Circulo("amarillo", 9),
				new Cuadrado("rojo", 3), new Rectangulo("rosa", 27, 4), new Circulo("amarillo", 29),
				new Cuadrado("marrón", 2), new Rectangulo("azul", 17, 14), new Circulo("turquesa", 129), };

		System.out.println();
		System.out.println("Mostrar todas las figuras");
		for (Figura figura : figuras) {
			System.out.println(figura);
		}

		System.out.println();
		System.out.println("Mostrar figuras de area mayor de 100");
		for (Figura figura : figuras) {
			if (figura.area() > 100) {
				System.out.println(figura);
			}
		}

		System.out.println();
		System.out.println("Polimorfismo");

		Cuadrado cu = new Cuadrado("verde", 5);
		Circulo ci = new Circulo("morado", 10);
		Rectangulo r = new Rectangulo("amarillo", 7, 3);

		Figura f2 = cu;
		Figura f3 = r;
		Figura f4 = ci;

		Cuadrado c3 = (Cuadrado) f2;

		System.out.println(f2 instanceof Circulo); // false
		System.out.println(f3 instanceof Circulo); // false
		System.out.println(f4 instanceof Circulo); // true
		System.out.println(f4 instanceof Figura); // true
		// System.out.println(cu instanceof Circulo); // da error ya que no es posible

	}
}
