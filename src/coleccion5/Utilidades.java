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
	 		int longitud = cadena.length();
	 		String resultado = "";   //variable donde iremos guardando el resultado
	 		for (int i=0; i<longitud; i++) {
	 			resultado = cadena.charAt(i)+resultado;
	 		}
	 		
	 		
	 		return resultado;

	 	} //fin del método fraseAlReves
	
	
	/**
	  * Método que comprueba si una cadena es palíndroma, es decir, si es igual a su cadena invertida
	  * Para comprobarlo, se ignoran mayúsculas/minúsculas y se ignoran también los espacios en blanco
	 * @param cadena: String con la cadena de entrada
	 * @return:  true si la cadena es palíndroma, false en caso contrario
	 * Corresponde al Ejercicio 3, colección 5
	 */
	public static boolean esPalindromo (String cadena){
		
		// eliminamos primero los espacios el blanco de la cadena de entrada
		String cadenaSinBlancos="";   
		char letra;
		for (int i=0; i<cadena.length(); i++){
			if ((letra=cadena.charAt(i)) != ' '){
				cadenaSinBlancos += letra;
			}
			//en caso contrario, si es un blanco, se ignora
		}
		
	 	String cadenaInvertida = Utilidades.fraseAlReves(cadenaSinBlancos);
	 	//comparamos las 2 cadenas con el método equalsIgnoreCase, que no diferencia entre mayúsculas y minúsculas
	 	return   cadenaSinBlancos.equalsIgnoreCase(cadenaInvertida);       
	 } //fin del método
	
	/**
	 * Método estático para calcular la cantidad de monedas a entregar para dar un cambio
	 * @param euros cantidad de la que debe devolverse el cambio, en euros. Debe ser positiva e inferior a 10 euros
	 * Corresponde al ejercicio 5 de la colección 5
	 */
	public static void devolverCambio (double euros){
		
		//sólo vamos a devolver el cambio en monedas de euros
		
		
		if (euros >=10) {
			System.out.println(" No entrego cambio para más de 10 euros");
			return;
		} else if (euros<=0){
			System.out.println(" Debes introducir un importe de al menos 0.01 euros");
			return;
		}
		
		else{
			
			//variables con las posibles monedas de céntimos, que inicializamos a 0
			int cent_1=0, cent_2=0, cent_5=0, cent_10=0, cent_20=0, cent_50=0;
			//variables con las posibles monedas de euro, que inicializamos a 0
			int eur_1=0, eur_2=0;
			//convertimos la cantidad a céntimos de euro
			int centimos=(int)(euros*100) ;  
			
			/* Para cada moneda, realizamos el cálculo en dos pasos
			 * 1: Obtenemos el número de monedas de ese valor realizando la división entera por dicho valor
			 * 2: OBtenemos el importe en céntimos aún no convertido como el resto de dividir entre ese valor
			 * Empezamos por la moneda de mayor valor, la de 2 euros
			 */
			if(centimos>=200){
				eur_2= centimos / 200 ;  //cantidad de monedas de 2 euros
				centimos = centimos % 200; //cantidad que no podemos convertir en monedas de 2 euros
			}
			
			if(centimos>=100){
				eur_1= centimos / 100 ;  //cantidad de monedas de 1 euro
				centimos = centimos % 100;
			}
			
			if(centimos>=50){
				cent_50 = centimos / 50 ;  //cantidad de monedas de 50 céntimos
				centimos = centimos % 50;
			}
			
			if(centimos>=20){
				cent_20 = centimos / 20 ;  //cantidad de monedas de 20 céntimos
				centimos = centimos % 20;
			}
			
			if(centimos>=10){
				cent_10 = centimos / 10 ;  //cantidad de monedas de 10 céntimos
				centimos = centimos % 10;
			}
			
			if(centimos>=5){
				cent_5 = centimos / 5 ;  //cantidad de monedas de 5 céntimos
				centimos = centimos % 5;
			}
			
			if(centimos>=2){
				cent_2 = centimos / 2 ;//cantidad de monedas de 2 céntimos
			}
			
			cent_1 = centimos % 2 ;   //lo que quede, serán monedas de 1 céntimo
			
			/* este ejercicio sería más corto y elegante con colecciones 
			 * pero aún no las conocemos...
			 */
			
			/*hechas las operaciones, hay que imprimir los resultados
			 * sólo mostramos los valores de monedas de las que se devuelve alguna
			 */
			System.out.print(eur_2 > 0 ? "\n Monedas de 2 euros: " +eur_2 : "");
			System.out.print(eur_1 > 0 ? "\nMonedas de 1 euro: " +eur_1 : "");
			System.out.print( cent_50 > 0 ? " \nMonedas de 50 céntimos: " +cent_50 : "");
			System.out.print( cent_20 > 0 ? "\n Monedas de 20 céntimos: " +cent_20 : "");
			System.out.print( cent_10 > 0 ? "\n Monedas de 10 céntimos: " +cent_10 : "");
			System.out.print( cent_5 > 0 ? "\n Monedas de 5 céntimos: " +cent_5 : "");
			System.out.print( cent_2 > 0 ? "\n Monedas de 2 céntimos: " +cent_2 : "");
			System.out.print( cent_1 > 0 ? "\n Monedas de 1 céntimo: " +cent_1 : "");		
			
			
		} //fin del else
			
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
		 
		//número de palabras que contamos
		 int palabras = 0;         
		 // esta variable la usamos para indicar si el anterior carácter era también separador
		 boolean prev_separador = false;
		 
		 for (int i=0; i < cadena.length(); i++) {
			 if ( cadena.charAt(i) ==' ' || cadena.charAt(i) =='\t' ||cadena.charAt(i) =='\n') {
				 // si el anterior carácter no era separador, estamos ante una nueva palabra
				 if (!prev_separador) {
					    palabras++;
				 }	    
				 //en cualquier caso, marcamos a True la variable prev_separador 
				 // así, si el próximo caracter es también separador, no se contará una nueva palabra
				 prev_separador = true;
			 }
			 // si el carácter no es separador, no incrementamos el número de palabras y ponemos a false la variable
			 else {
				 prev_separador = false;
			 }
				 
		} // finaliza el bucle for
		 
		 //si la cadena no es vacía, hay que sumar la última palabra, que no va seguida de separador
		 return   (cadena.length() >0 ? palabras+1 : palabras);
	 }  //fin del método cuentaPalabras
	 
	 
	 /**
	  * Ejercicio que lee 3 números y los devuelve ordenados de menor a mayor
	 * @param num1: double. primer número
	 * @param num2:	double. segundo número
	 * @param num3: 	double. tercer número
	 */
	public static void ordenar3Numeros (double num1, double num2, double num3 ){
		 
		 /*Una forma de abordarlo es dándonos  cuenta de que con 3 números, las ordenaciones posibles son 6
		  * en generar con N números las ordenaciones posibles vienen dadas por N!
		  * ya sólo con 4, tendremos 4! = 24 ordenaciones, por lo que este algoritmo sólo es admisible hasta 3
		  */
		 if (num1 <= num2  && num2 <= num3)
			System.out.println( "El orden es :" + num1 + " <= " +num2 + " <= " + num3) ;
		 else if (num1 <= num3  && num3 <= num2)
			 System.out.println( "El orden es :" + num1 + " <= " +num3 + " <= " + num2) ;
		 else if (num2 <= num1  && num1 <= num3)
			 System.out.println( "El orden es :" + num2 + " <= " +num1 + " <= " + num3) ;
		 else if (num2 <= num3  && num3 <= num1)
			 System.out.println( "El orden es :" + num2 + " <= " +num3 + " <= " + num1) ;
		 else if (num3 <= num1  && num1 <= num2)
			 System.out.println( "El orden es :" + num3 + " <= " +num1 + " <= " + num2) ;
		 else if (num3 <= num2  && num2 <= num1)
			 System.out.println( "El orden es :" + num3 + " <= " +num2 + " <= " + num1) ;
		 

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
		
		//comprobamos que el número de intentos sea al menos 1000
		if (intentos < 1000) {
			System.out.println("El número mínimo de intentos es de 1000");
			
		} else {
		
			//inicializamos un objeto de la clase SecureRandom
			SecureRandom azar= new SecureRandom();
			
			//valores iniciales de las caras y cruces obtenidas
			int cara=0, cruz=0;
			for (int i=0; i< intentos; i++){
				//el método nextDouble() genera un número decimal aleatorio entre 0 y 1, sin llegar a 1
				if (azar.nextDouble()<0.5) {
					cara ++;
				} else { 
					cruz++;
				}
			}
			//al final del bucle, imprimimos los resultados:
			
			System.out.format("\nNúmero de caras : %d: * Porcentaje : %.2f %%", cara, (100.0*cara)/intentos);
			System.out.format("\nNúmero de cruces : %d: * Porcentaje : %.2f %%", cruz, (100.0*cruz)/intentos);
		}
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
	 
	

