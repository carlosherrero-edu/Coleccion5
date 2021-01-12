package coleccion5;

public class ProbarContarCifras {

	public static void main(String[] args) {
		// array con los valores que vamos a probar. 
		int valores[] = {  1,9,10,99,100,999,1000,9999,10000,99999,100000,999999,1000000};
		

		for (int numero: valores) {
			//primero probamos el método con el valor positivo
			System.out.format("\n El número %d  tiene %d cifras ", numero, Utilidades.contarCifras(numero));
			//ahora probamos el método con el valor negativo
			System.out.format("\n El número %d  tiene %d cifras ", (-1)*numero, Utilidades.contarCifras((-1)*numero));
		}

	}

}
