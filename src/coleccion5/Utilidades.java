package coleccion5;

import java.security.SecureRandom;

/**
 * @author Carlos H.
 *
 */
public class Utilidades {
	
	/**
	 * Método que calcula la suma de los primeros números pares consecutivos
	 * @param limite : cantidad de números pares que queremos sumar, debe ser >=1
	 * @return long:  valor con la suma, entero largo para aumentar la precisión
	 * @return -1:  si el parámetro es menor de 1
	 * Ejercicio 1, colección 5
	 */
	public static long sumaPares (int limite) {
		
		// si el parámetro es <1, devolvermos un error
		if (limite <1) {
			return -1;
		}
		
		long suma= 0L;
		
		
		for (int i=1; i<=limite; i++) {
			suma +=  i*2;
		}
		
		return suma;
	} //fin del método sumaPares
	
	
	/**
	 * Método para calcular los primeros términos de la serie o sucesión de Fibonacci
	 * @param n entero con el número de términos a calcular. Debe ser mayor de 2
	 * Los primeros términos son  a1=1  , a2= 1
	 * los siguientes términos se calculan por la fórmula  general:an= an-1 + an-2

	 */
	public static void imprimirFibonacci (int n) {
		
		//como la sucesión de Fibonacci crece deprisa, almacenaremos sus términos en variables de tipo long
		long siguiente;
		//primeros términos de la sucesión
		long primero=1L, segundo=1L;
		//número de términos calculados
		int contador=1;
		
		if (n>2) {
			System.out.format("\n Término  %d : %d", contador++, primero);
			System.out.format("\n Término  %d : %d", contador++, segundo);
			while (contador <= n) {
				siguiente = primero+ segundo;   //sumanos los 2 términos anteriores
				primero = segundo;   //el primer término lo actualizamos al segundo
				segundo = siguiente;  //el segundo término lo actualizamos al valor de la suma
				System.out.format("\n Término  %d : %d", contador++, siguiente);
			}
			
		} else {
			System.out.println("Debes introducir un número de términos superior a 2");
		}
	}//fin del método
	
	
	/**
	 * Función que cuenta el número de cifras de un número entero 
	 * @param n valor del entero, suponemos que inferior en valor absoluto a 10^9
	 * @return  número de cifras del número
	 * Corresponde a Ejercicio 4 de la Colección 5
	 */
	public static int contarCifras (int n) {
		
		int num_cifras=0;
		//si el número es negativo, lo pasamos a valor positivo
		if (n<0) {
			n = (-1)*n;
		}
		
		while (n>0) {
			num_cifras++;
			n = n /10;  //hacemos la división entera entre 10 en cada paso
		}
	
		return num_cifras;
		
		
	}
	
	
	/**
	  * Método que lee una cadena y devuelve la cadena con los caracteres invertidos
	 * @param cadena: String con la cadena de entrada
	 * @return: String con la cadena invertida
	 * Corresponde al Ejercicio3, Colección 5
	 */
	public static String fraseAlReves (String cadena){
	 		
	 		return "";

	 	} //fin del método fraseAlReves
	
	
	/**
	  * Método que comprueba si una cadena es palíndroma, es decir, si es igual a su cadena invertida
	  * Para comprobarlo, se ignoran mayúsculas/minúsculas y se ignoran también los espacios en blanco
	 * @param cadena: String con la cadena de entrada
	 * @return:  true si la cadena es palíndroma, false en caso contrario
	 * Corresponde al Ejercicio 3, colección 5
	 */
	public static boolean esPalindromo (String cadena){
		
		return true; 
	 } //fin del método
	
	/**
	 * Método estático para calcular la cantidad de monedas a entregar para dar un cambio
	 * @param euros cantidad de la que debe devolverse el cambio, en euros. Debe ser positiva e inferior a 10 euros
	 * Corresponde al ejercicio 5 de la colección 5
	 */
	public static void devolverCambio (double euros){
		
		
			
	}  //fin del método devolverCambio
	
	
	/**
	 * Método que cuenta el número de palabras que existe en un texto
	 * Se consideran como separadores válidos de 2 palabras los siguientes caracteres
	 *     -el espacio en blanco
	 *     -el tabulador \t y 
	 *      -el carácter de nueva línea \n
	 * El método trata el caso en que haya varios separadores consecutivos entre 2 palabras
	* @param cadena: String con el texto del que contaremos el número de paoalbras
	* @return:  entero con el número de palabras encontrado
	* Corresponde al Ejercicio 6, colección5 
	*/
	 public static int cuentaPalabras (String cadena){
		 
	
		 return 0;      
		
	 }  //fin del método cuentaPalabras
	 
	 
	 /**
	  * Ejercicio que lee 3 números y los devuelve ordenados de menor a mayor
	 * @param num1: double. primer número
	 * @param num2:	double. segundo número
	 * @param num3: 	double. tercer número
	 */
	public static void ordenar3Numeros (double num1, double num2, double num3 ){
		 
		
		 

	 }//fin del método
	
	/**
	 * Mëtodo que simula la obtención de los resultados de una quiniela de forma aleatoria
	 * 
	 * @return cadena con los resultados obtenidos 
	 * Corresponde al Ejercicio 9 de la colección 5
	 */
	public static String apostarQuiniela () {
		
		String resultado ="";
		
		return resultado;
	}
	/**
	 * Método que simula varios lanzamientos sucesivos de una moneda y presenta los resultados
	 * Al final muestra el número de caras y cruces, así como su porcentaje
	 * @param intentos  número de intentos, al menos debe ser 1000
	 * Corresponde al ejercicio 10 de la Colección 5
	 */
	public static void lanzarMoneda (int intentos) {
		
		
	} //fin del método

	/**
	 * Método que sustituye una frase por otra de igual longitud en la cual cada letra
	 * se desplaza hacia adelante un número de posiciones indicada por el entero "desplaza"
	 * Para ello, imaginemos que las letras de la A a la Z se disponen sobre una circunferencia
	 * Cuando nos desplacemos más allá de la Z, comenzamos de nuevo por la A
	 *
	 * Por ejemplo, si entre la A y la Z hubiese 26 letras y nos tenemos que desplazar 3 letras
	 * la Y se transformará en la B. 
	 * Es esencial el uso de la función resto
	 * @param frase String con la frase original
	 * @param desplaza  desplazamiento, comprendido entre 1 y 25
	 * @return String con la frase desplazada hacia adelante o hacia la derecha
	 * Corresponde al Ejercicio 11 de la Colección 5
	 */
	public static String desplazarLetras (String frase, int desplaza){
		
		
		String fraseDesplazada="";
		
		
		return fraseDesplazada;
		
	}
	
	/**
	 * Método que sustituye una frase por otra de igual longitud en la cual cada letra
	 * se desplaza hacia atrás un número de posiciones indicada por el entero "desplaza"
	 * Para ello, imaginemos que las letras de la A a la Z se disponen sobre una circunferencia
	 * Cuando nos encontremos más allá de la Z, comenzamos de nuevo por la A
	 * @param frase String con la frase original
	 * @param desplaza  desplazamiento, comprendido entre 1 y 25
	 * @return String con la frase desplazada "hacia atrás" o hacia la izquierda
	 *  Corresponde al Ejercicio 12 de la Colección 5
	 */
	public static String desplazarLetras2 (String frase, int desplaza){
		
			
			String fraseDesplazada="";
			
			
			return fraseDesplazada;
		
		
		
	}
	
	/**
	 * Método para calcular el máximo común divisor de 2 números enteros usando el algoritmo de Euclides
	 * @param num1: primer número entero , debe ser >0
	 * @param num2: segundo número entero, debe ser >0
	 * @return: entero que expresa el máximo común divisor
	 * Corresponde al Ejercicio 13, Colección 5
	 */
	public static int maximoComun (int num1, int num2)  {

		//inicialización de valores del algoritmo
		int m, n, resto;   //variables que vamos a utilizar para el algoritmo
		//seleccionamos m y n de forma que m>=n
		if (num1>num2){
			m= num1;
			n=num2;
		} else {
			m= num2;
			n= num1;
		}
		
		//ejecución del algoritmo -- al menos 1 vez
		do{
			resto = m % n;
			m = n;
			n = resto;
			
		} while (resto !=0);
		
		//devolución del resultado
		return m;
	}
	//fin del método maximoComun
	
	/**
	 * Método para calcular el minimo comúm múltiplo de 2 números enteros
	 * @param num1: primer número entero , debe ser >0
	 * @param num2: segundo número entero, debe ser >0
	 * @return: entero que expresa el mínimo común múltiplo.
	 * @throws  IllegalArgumentException  si los números no son enteros positivos
	 * Corresponde al Ejercicio 13, Colección 5
	 */	
public static int minimoComun (int num1, int num2) {

		
		return   num1*num2 / maximoComun(num1, num2);
}
//fin del método minimoComun	

/**
 * Ejercicio 19, Hoja 4
 * Método que determina si 2 números enteros son primos entre sí
 * @param num1: primer número entero >0
 * @param num2: segundo número entero >0
 * @return: true si son primos entre sí, false en caso contrario
 * Corresponde al ejercicio 14 de la Colección 5
 */
public static boolean primosMutuos(int num1, int num2) {
	
	
	
	if (maximoComun (num1, num2) >1)
		return false;
	else
		return true;
	
}
//fin del método primosEntreSi

/**
 * Método que determina si un número es primo
 * Para ello, se van probando como divisores posibles todos los enteros desde 2 hasta el más próximo a la raíz del número
 * @param num:  número entero >2
 * @return: true si es número primo, false en caso contrario
 * Corresponde al Ejercicio 14, Colección 5
 */

public static boolean esPrimo (int num) {
	

		boolean esPrimo=true;
		
		for (int i=2 ; i<=Math.sqrt(num); i++){
			 
			if ((num % i) ==0){
				//si es divisible entre i, no puede ser primo, por lo que salimos del bucle
				esPrimo=false;
				break;			
			}
			
		} //fin del bucle for
		
		return esPrimo;
	
	
}//fin del método esPrimo


}
