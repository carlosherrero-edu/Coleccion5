package coleccion5;

import java.security.SecureRandom;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		// Objetos que necesitamos para el programa
		Scanner teclado= new Scanner(System.in);
		//utilizamos la clase SecureRandom que genera números más aleatorios
		SecureRandom random= new SecureRandom();
		//obtenemos un número aleatorio entre 1 y 1oo
		int adivinar= random.nextInt(100) +1; 
		
		boolean hasAcertado= false;
		int intentos=0; //contador para controlar el n�mero de intentos
		int numero;		//n�mero que debemos adivinar
		System.out.println("  **** ADIVINA EL NUMERO ****");
		System.out.println("       -----------------");
		System.out.println("\n Adivina un n�mero entre 1 y 100. Tienes 6 intentos");
		do {
			
			System.out.printf(" Intento  %d : �Qu� numero es ? : ",++intentos);
			
				numero = teclado.nextInt();
				
				//nos aseguramos de que el n�mero introducido se encuentre entre 1 y 100
				while ( numero<1 || numero >100) {
					System.out.print("El n�mero debe estar entre 1 y 100. Vuelve a intentarlo  :");
					numero = teclado.nextInt();
				}
				
			if (numero == adivinar) {
				hasAcertado= true;
			} else if (numero > adivinar) {
				System.out.println(" Has introducido un n�mero demasiado grande");
			}else {
				System.out.println(" Has introducido un n�mero demasiado peque�o");
			}
		}while (!hasAcertado && intentos <6);
		
		if (hasAcertado) {
			System.out.printf( "���Felicidades !!! Acertaste en  %d intentos", intentos);
		} else {
			System.out.println("���Agotaste tus intentos. Otra vez ser� !!!");
		}
		
		
	teclado.close();	

	}

}
