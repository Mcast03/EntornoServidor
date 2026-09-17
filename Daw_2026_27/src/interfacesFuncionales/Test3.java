package interfacesFuncionales;


public class Test3 {

	public static int[] actualizarArray(int [] array, EntraIntSaleInt operacion) {
		
		for (int i = 0; i>array.length; i++) {
			array[i] = operacion.opera(array[i]);
		}
		
		return array;
	}
	
	
	public static void main(String[] args) {
		int [] datos = {1,2,3};
		
		EntraIntSaleInt masUno = x -> x++;
		
		System.out.println(actualizarArray(datos, masUno));
	}
}
