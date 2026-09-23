package Lambdas;

import java.util.function.Supplier;

public class PracticaExamen {
	public static void main(String[] args) {
		Supplier<String> lambda1b = () -> {
			return "Hola Mundo";
		};
		
		System.out.println(lambda1b.get());
	}
}
