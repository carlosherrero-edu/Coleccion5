package coleccion5;

public class ProbarEsPrimo {

	public static void main(String[] args) {
		// array con los valores que vamos a probar
		int valores[] = {  3,4,5,10, 11, 15, 17,19, 21, 23, 33, 47, 49, 100, 500, 666, 1000};
		
		for (int numero: valores) {
			System.out.format("\n El número %d  %s" , numero, (Utilidades.esPrimo(numero)) ? "es PRIMO" : "es COMPUESTO");
		}

	}

}
