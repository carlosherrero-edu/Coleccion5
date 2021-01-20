package coleccion5;

import java.security.SecureRandom;

/**
 * @author Carlos H.
 *
 */
public class Utilidades {
	
	/**
	 * M�todo que calcula la suma de los primeros n�meros pares consecutivos
	 * @param limite : cantidad de n�meros pares que queremos sumar, debe ser >=1
	 * @return long:  valor con la suma, entero largo para aumentar la precisi�n
	 * @return -1:  si el par�metro es menor de 1
	 * Ejercicio 1, colecci�n 5
	 */
	public static long sumaPares (int limite) {
		
		// si el par�metro es <1, devolvermos un error
		if (limite <1) {
			return -1;
		}
		
		long suma= 0L;
		
		
		for (int i=1; i<=limite; i++) {
			suma +=  i*2;
		}
		
		return suma;
	} //fin del m�todo sumaPares
	
	
	/**
	 * M�todo para calcular los primeros t�rminos de la serie o sucesi�n de Fibonacci
	 * @param n entero con el n�mero de t�rminos a calcular. Debe ser mayor de 2
	 * Los primeros t�rminos son  a1=1  , a2= 1
	 * los siguientes t�rminos se calculan por la f�rmula  general:an= an-1 + an-2

	 */
	public static void imprimirFibonacci (int n) {
		
		//como la sucesi�n de Fibonacci crece deprisa, almacenaremos sus t�rminos en variables de tipo long
		long siguiente;
		//primeros t�rminos de la sucesi�n
		long primero=1L, segundo=1L;
		//n�mero de t�rminos calculados
		int contador=1;
		
		if (n>2) {
			System.out.format("\n T�rmino  %d : %d", contador++, primero);
			System.out.format("\n T�rmino  %d : %d", contador++, segundo);
			while (contador <= n) {
				siguiente = primero+ segundo;   //sumanos los 2 t�rminos anteriores
				primero = segundo;   //el primer t�rmino lo actualizamos al segundo
				segundo = siguiente;  //el segundo t�rmino lo actualizamos al valor de la suma
				System.out.format("\n T�rmino  %d : %d", contador++, siguiente);
			}
			
		} else {
			System.out.println("Debes introducir un n�mero de t�rminos superior a 2");
		}
	}//fin del m�todo
	
	
	/**
	 * Funci�n que cuenta el n�mero de cifras de un n�mero entero 
	 * @param n valor del entero, suponemos que inferior en valor absoluto a 10^9
	 * @return  n�mero de cifras del n�mero
	 * Corresponde a Ejercicio 4 de la Colecci�n 5
	 */
	public static int contarCifras (int n) {
		
		int num_cifras=0;
		//si el n�mero es negativo, lo pasamos a valor positivo
		if (n<0) {
			n = (-1)*n;
		}
		
		while (n>0) {
			num_cifras++;
			n = n /10;  //hacemos la divisi�n entera entre 10 en cada paso
		}
	
		return num_cifras;
		
		
	}
	
	
	/**
	  * M�todo que lee una cadena y devuelve la cadena con los caracteres invertidos
	 * @param cadena: String con la cadena de entrada
	 * @return: String con la cadena invertida
	 * Corresponde al Ejercicio3, Colecci�n 5
	 */
	public static String fraseAlReves (String cadena){
	 		int longitud = cadena.length();
	 		String resultado = "";   //variable donde iremos guardando el resultado
	 		for (int i=0; i<longitud; i++) {
	 			resultado = cadena.charAt(i)+resultado;
	 		}
	 		
	 		
	 		return resultado;

	 	} //fin del m�todo fraseAlReves
	
	
	/**
	  * M�todo que comprueba si una cadena es pal�ndroma, es decir, si es igual a su cadena invertida
	  * Para comprobarlo, se ignoran may�sculas/min�sculas y se ignoran tambi�n los espacios en blanco
	 * @param cadena: String con la cadena de entrada
	 * @return:  true si la cadena es pal�ndroma, false en caso contrario
	 * Corresponde al Ejercicio 3, colecci�n 5
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
	 	//comparamos las 2 cadenas con el m�todo equalsIgnoreCase, que no diferencia entre may�sculas y min�sculas
	 	return   cadenaSinBlancos.equalsIgnoreCase(cadenaInvertida);       
	 } //fin del m�todo
	
	/**
	 * M�todo est�tico para calcular la cantidad de monedas a entregar para dar un cambio
	 * @param euros cantidad de la que debe devolverse el cambio, en euros. Debe ser positiva e inferior a 10 euros
	 * Corresponde al ejercicio 5 de la colecci�n 5
	 */
	public static void devolverCambio (double euros){
		
		//s�lo vamos a devolver el cambio en monedas de euros
		
		
		if (euros >=10) {
			System.out.println(" No entrego cambio para m�s de 10 euros");
			return;
		} else if (euros<=0){
			System.out.println(" Debes introducir un importe de al menos 0.01 euros");
			return;
		}
		
		else{
			
			//variables con las posibles monedas de c�ntimos, que inicializamos a 0
			int cent_1=0, cent_2=0, cent_5=0, cent_10=0, cent_20=0, cent_50=0;
			//variables con las posibles monedas de euro, que inicializamos a 0
			int eur_1=0, eur_2=0;
			//convertimos la cantidad a c�ntimos de euro
			int centimos=(int)(euros*100) ;  
			
			/* Para cada moneda, realizamos el c�lculo en dos pasos
			 * 1: Obtenemos el n�mero de monedas de ese valor realizando la divisi�n entera por dicho valor
			 * 2: OBtenemos el importe en c�ntimos a�n no convertido como el resto de dividir entre ese valor
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
				cent_50 = centimos / 50 ;  //cantidad de monedas de 50 c�ntimos
				centimos = centimos % 50;
			}
			
			if(centimos>=20){
				cent_20 = centimos / 20 ;  //cantidad de monedas de 20 c�ntimos
				centimos = centimos % 20;
			}
			
			if(centimos>=10){
				cent_10 = centimos / 10 ;  //cantidad de monedas de 10 c�ntimos
				centimos = centimos % 10;
			}
			
			if(centimos>=5){
				cent_5 = centimos / 5 ;  //cantidad de monedas de 5 c�ntimos
				centimos = centimos % 5;
			}
			
			if(centimos>=2){
				cent_2 = centimos / 2 ;//cantidad de monedas de 2 c�ntimos
			}
			
			cent_1 = centimos % 2 ;   //lo que quede, ser�n monedas de 1 c�ntimo
			
			/* este ejercicio ser�a m�s corto y elegante con colecciones 
			 * pero a�n no las conocemos...
			 */
			
			/*hechas las operaciones, hay que imprimir los resultados
			 * s�lo mostramos los valores de monedas de las que se devuelve alguna
			 */
			System.out.print(eur_2 > 0 ? "\n Monedas de 2 euros: " +eur_2 : "");
			System.out.print(eur_1 > 0 ? "\nMonedas de 1 euro: " +eur_1 : "");
			System.out.print( cent_50 > 0 ? " \nMonedas de 50 c�ntimos: " +cent_50 : "");
			System.out.print( cent_20 > 0 ? "\n Monedas de 20 c�ntimos: " +cent_20 : "");
			System.out.print( cent_10 > 0 ? "\n Monedas de 10 c�ntimos: " +cent_10 : "");
			System.out.print( cent_5 > 0 ? "\n Monedas de 5 c�ntimos: " +cent_5 : "");
			System.out.print( cent_2 > 0 ? "\n Monedas de 2 c�ntimos: " +cent_2 : "");
			System.out.print( cent_1 > 0 ? "\n Monedas de 1 c�ntimo: " +cent_1 : "");		
			
			
		} //fin del else
			
	}  //fin del m�todo devolverCambio
	
	
	/**
	 * M�todo que cuenta el n�mero de palabras que existe en un texto
	 * Se consideran como separadores v�lidos de 2 palabras los siguientes caracteres
	 *     -el espacio en blanco
	 *     -el tabulador \t y 
	 *      -el car�cter de nueva l�nea \n
	 * El m�todo trata el caso en que haya varios separadores consecutivos entre 2 palabras
	* @param cadena: String con el texto del que contaremos el n�mero de paoalbras
	* @return:  entero con el n�mero de palabras encontrado
	* Corresponde al Ejercicio 6, colecci�n5 
	*/
	 public static int cuentaPalabras (String cadena){
		 
		//n�mero de palabras que contamos
		 int palabras = 0;         
		 // esta variable la usamos para indicar si el anterior car�cter era tambi�n separador
		 boolean prev_separador = false;
		 
		 for (int i=0; i < cadena.length(); i++) {
			 if ( cadena.charAt(i) ==' ' || cadena.charAt(i) =='\t' ||cadena.charAt(i) =='\n') {
				 // si el anterior car�cter no era separador, estamos ante una nueva palabra
				 if (!prev_separador) {
					    palabras++;
				 }	    
				 //en cualquier caso, marcamos a True la variable prev_separador 
				 // as�, si el pr�ximo caracter es tambi�n separador, no se contar� una nueva palabra
				 prev_separador = true;
			 }
			 // si el car�cter no es separador, no incrementamos el n�mero de palabras y ponemos a false la variable
			 else {
				 prev_separador = false;
			 }
				 
		} // finaliza el bucle for
		 
		 //si la cadena no es vac�a, hay que sumar la �ltima palabra, que no va seguida de separador
		 return   (cadena.length() >0 ? palabras+1 : palabras);
	 }  //fin del m�todo cuentaPalabras
	 
	 
	 /**
	  * Ejercicio que lee 3 n�meros y los devuelve ordenados de menor a mayor
	 * @param num1: double. primer n�mero
	 * @param num2:	double. segundo n�mero
	 * @param num3: 	double. tercer n�mero
	 */
	public static void ordenar3Numeros (double num1, double num2, double num3 ){
		 
		 /*Una forma de abordarlo es d�ndonos  cuenta de que con 3 n�meros, las ordenaciones posibles son 6
		  * en generar con N n�meros las ordenaciones posibles vienen dadas por N!
		  * ya s�lo con 4, tendremos 4! = 24 ordenaciones, por lo que este algoritmo s�lo es admisible hasta 3
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
		 

	 }//fin del m�todo
	
	/**
	 * M�todo que simula la obtenci�n de los resultados de una quiniela de forma aleatoria
	 * 
	 * @return cadena con los resultados obtenidos 
	 * Corresponde al Ejercicio 9 de la colecci�n 5
	 */
	public static String apostarQuiniela () {
		
		String resultado ="";
		
		
		return resultado;
	}
	/**
	 * M�todo que simula varios lanzamientos sucesivos de una moneda y presenta los resultados
	 * Al final muestra el n�mero de caras y cruces, as� como su porcentaje
	 * @param intentos  n�mero de intentos, al menos debe ser 1000
	 * Corresponde al ejercicio 10 de la Colecci�n 5
	 */
	public static void lanzarMoneda (int intentos) {
		
		//comprobamos que el n�mero de intentos sea al menos 1000
		if (intentos < 1000) {
			System.out.println("El n�mero m�nimo de intentos es de 1000");
			
		} else {
		
			//inicializamos un objeto de la clase SecureRandom
			SecureRandom azar= new SecureRandom();
			
			//valores iniciales de las caras y cruces obtenidas
			int cara=0, cruz=0;
			for (int i=0; i< intentos; i++){
				//el m�todo nextDouble() genera un n�mero decimal aleatorio entre 0 y 1, sin llegar a 1
				if (azar.nextDouble()<0.5) {
					cara ++;
				} else { 
					cruz++;
				}
			}
			//al final del bucle, imprimimos los resultados:
			
			System.out.format("\nN�mero de caras : %d: * Porcentaje : %.2f %%", cara, (100.0*cara)/intentos);
			System.out.format("\nN�mero de cruces : %d: * Porcentaje : %.2f %%", cruz, (100.0*cruz)/intentos);
		}
	} //fin del m�todo

	/**
	 * M�todo que sustituye una frase por otra de igual longitud en la cual cada letra
	 * se desplaza hacia adelante un n�mero de posiciones indicada por el entero "desplaza"
	 * Para ello, imaginemos que las letras de la A a la Z se disponen sobre una circunferencia
	 * Cuando nos desplacemos m�s all� de la Z, comenzamos de nuevo por la A
	 *
	 * Por ejemplo, si entre la A y la Z hubiese 26 letras y nos tenemos que desplazar 3 letras
	 * la Y se transformar� en la B. 
	 * Es esencial el uso de la funci�n resto
	 * @param frase String con la frase original
	 * @param desplaza  desplazamiento, comprendido entre 1 y 25
	 * @return String con la frase desplazada hacia adelante o hacia la derecha
	 * Corresponde al Ejercicio 11 de la Colecci�n 5
	 */
	public static String desplazarLetras (String frase, int desplaza){
		
		
		String fraseDesplazada="";
		
		return fraseDesplazada;
		
	}
	
	/**
	 * M�todo que sustituye una frase por otra de igual longitud en la cual cada letra
	 * se desplaza hacia atr�s un n�mero de posiciones indicada por el entero "desplaza"
	 * Para ello, imaginemos que las letras de la A a la Z se disponen sobre una circunferencia
	 * Cuando nos encontremos m�s all� de la Z, comenzamos de nuevo por la A
	 * @param frase String con la frase original
	 * @param desplaza  desplazamiento, comprendido entre 1 y 25
	 * @return String con la frase desplazada "hacia atr�s" o hacia la izquierda
	 *  Corresponde al Ejercicio 12 de la Colecci�n 5
	 */
	public static String desplazarLetras2 (String frase, int desplaza){
		
			
			String fraseDesplazada="";
		
			
			return fraseDesplazada;
		
		
		
	}
	
	/**
	 * M�todo para calcular el m�ximo com�n divisor de 2 n�meros enteros usando el algoritmo de Euclides
	 * @param num1: primer n�mero entero , debe ser >0
	 * @param num2: segundo n�mero entero, debe ser >0
	 * @return: entero que expresa el m�ximo com�n divisor
	 * Corresponde al Ejercicio 13, Colecci�n 5
	 */
	public static int maximoComun (int num1, int num2)  {

		//inicializaci�n de valores del algoritmo
		int m, n, resto;   //variables que vamos a utilizar para el algoritmo
		//seleccionamos m y n de forma que m>=n
		if (num1>num2){
			m= num1;
			n=num2;
		} else {
			m= num2;
			n= num1;
		}
		
		//ejecuci�n del algoritmo -- al menos 1 vez
		do{
			resto = m % n;
			m = n;
			n = resto;
			
		} while (resto !=0);
		
		//devoluci�n del resultado
		return m;
	}
	//fin del m�todo maximoComun
	
	/**
	 * M�todo para calcular el minimo com�m m�ltiplo de 2 n�meros enteros
	 * @param num1: primer n�mero entero , debe ser >0
	 * @param num2: segundo n�mero entero, debe ser >0
	 * @return: entero que expresa el m�nimo com�n m�ltiplo.
	 * @throws  IllegalArgumentException  si los n�meros no son enteros positivos
	 * Corresponde al Ejercicio 13, Colecci�n 5
	 */	
public static int minimoComun (int num1, int num2) {

		
		return   num1*num2 / maximoComun(num1, num2);
}
//fin del m�todo minimoComun	

/**
 * Ejercicio 19, Hoja 4
 * M�todo que determina si 2 n�meros enteros son primos entre s�
 * @param num1: primer n�mero entero >0
 * @param num2: segundo n�mero entero >0
 * @return: true si son primos entre s�, false en caso contrario
 * Corresponde al ejercicio 14 de la Colecci�n 5
 */
public static boolean primosMutuos(int num1, int num2) {
	
	
	
	if (maximoComun (num1, num2) >1)
		return false;
	else
		return true;
	
}
//fin del m�todo primosEntreSi

/**
 * M�todo que determina si un n�mero es primo
 * Para ello, se van probando como divisores posibles todos los enteros desde 2 hasta el m�s pr�ximo a la ra�z del n�mero
 * @param num:  n�mero entero >2
 * @return: true si es n�mero primo, false en caso contrario
 * Corresponde al Ejercicio 14, Colecci�n 5
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
	
	
}//fin del m�todo esPrimo



}
	 
	

