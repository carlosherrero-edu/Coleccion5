package coleccion5;

import java.security.SecureRandom;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		// Objetos que necesitamos para el programa
		Scanner teclado= new Scanner(System.in);
		//utilizamos la clase SecureRandom que genera nÃºmeros mÃ¡s aleatorios
		SecureRandom random= new SecureRandom();
		//obtenemos un nÃºmero aleatorio entre 1 y 1oo
		int adivinar= random.nextInt(100) +1; 
		
		boolean hasAcertado= false;
		int intentos=0; //contador para controlar el número de intentos
		int numero;		//número que debemos adivinar
		System.out.println("  **** ADIVINA EL NUMERO ****");
		System.out.println("       -----------------");
		System.out.println("\n Adivina un número entre 1 y 100. Tienes 6 intentos");
		do {
			
			System.out.printf(" Intento  %d : ¿Qué numero es ? : ",++intentos);
			
				numero = teclado.nextInt();
				
				//nos aseguramos de que el número introducido se encuentre entre 1 y 100
				while ( numero<1 || numero >100) {
					System.out.print("El número debe estar entre 1 y 100. Vuelve a intentarlo  :");
					numero = teclado.nextInt();
				}
				
			if (numero == adivinar) {
				hasAcertado= true;
			} else if (numero > adivinar) {
				System.out.println(" Has introducido un número demasiado grande");
			}else {
				System.out.println(" Has introducido un número demasiado pequeño");
			}
		}while (!hasAcertado && intentos <6);
		
		if (hasAcertado) {
			System.out.printf( "¡¡¡Felicidades !!! Acertaste en  %d intentos", intentos);
		} else {
			System.out.println("¡¡¡Agotaste tus intentos. Otra vez será¡ !!!");
		}
		
		
	teclado.close();	

	}

}
