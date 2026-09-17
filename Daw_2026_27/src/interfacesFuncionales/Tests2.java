package interfacesFuncionales;

public class Tests2 {
	public static void main(String[] args) {
		ComparacionStrings contieneParametroFI= (s1, s2) -> s1.contains(s2);
		System.out.println(contieneParametroFI.m("hola", "l"));
		
		UnParametroString numeroCaracteresFI= s1 -> s1.length()<3;
		System.out.println(numeroCaracteresFI.m("Pepe"));
		
		UnParametroString empiezaPorAFI= s1 -> s1.startsWith("A");
		System.out.println(empiezaPorAFI.m("Alemania"));
		
		UnParametroString terminaPorPuntoFI= s1 -> s1.endsWith(".");
		System.out.println(terminaPorPuntoFI.m("Antonio"));
		
		ComparacionStrings empiezaPorFI= (s1, s2) -> s1.startsWith(s2);
		System.out.println(empiezaPorFI.m("Pepe", "L"));
	}
}
