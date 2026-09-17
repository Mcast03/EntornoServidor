package interfacesFuncionales;

public class test1 {

	private static int cuadrado(int n) {
		return n * n;
	}
	
	private static int cubo(int n) {
		return n * n * n;
	}
	
	private static int doble(int n) {
		return n*2;
	}
	
	private static int triple(int n) {
		return n*3;
	}
	
	private static int polinomio(int n) {
		return 5 * (n*n*n) + 7 * (n * n) + 9;
	}
	
	private static int polinomioVariable(int a, int b, int c, int n) {
		return a * (n*n*n) + b * (n * n) + c;
	}

	public static void main(String[] args) {
		System.out.println(cuadrado(7));
		EntraIntSaleInt cuadradoFI = n -> n * n;
		System.out.println(cuadradoFI.opera(7));
		
		System.out.println(cubo(7));
		EntraIntSaleInt cuboFI = n -> n * n * n;
		System.out.println(cuboFI.opera(7));
		
		System.out.println(doble(7));
		EntraIntSaleInt dobleFI= n -> n*2;
		System.out.println(dobleFI.opera(7));
		
		System.out.println(triple(7));
		EntraIntSaleInt tripleFI= n -> n*3;
		System.out.println(tripleFI.opera(7));
		
		System.out.println(polinomio(7));
		EntraIntSaleInt polinomioFI= n -> 5 * (n*n*n) + 7 * (n * n) + 9;
		System.out.println(polinomioFI.opera(7));
		
		System.out.println(polinomioVariable(1, 2, 3, 4));
		EntranCuatroSaleUno polinomioVariableFI= (a,b,c,n) -> a * (n*n*n) + b * (n * n) + c;
		System.out.println(polinomioVariableFI.opera(1, 2, 3, 4));
		
		EntraEnteroSaleDecimal mitadFI= n -> n/2;
		System.out.println(mitadFI.opera(7));
		
		EntraEnteroSaleDecimal cuartoFI= n -> n/4;
		System.out.println(cuartoFI.opera(7));
		
		EntraEnteroSaleDecimal decimaFI= n -> n/10;
		System.out.println(decimaFI.opera(7));
		
		EntraEnteroSaleDecimal enesimaFI= n -> n/90;
		System.out.println(enesimaFI.opera(7));
		
		
	}

}
