package coleccion5;

import java.util.Scanner;

public class ProbarFibonacci {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
	
		boolean numeros_ok= false;
		int num1;
		
		do {
			//pediremos valores por teclado hasta que se entreguen n�meros v�lidos
			
			System.out.print("\n �Cu�ntos t�rminos quieres obtener de la serie de Fibonacci?   >>>");
			num1 = teclado.nextInt();
	
			
			if (num1>2) {
				// el valor es correctto, salimos del bucle
				numeros_ok=true;
			} else {
				//mostramos un aviso y continuamos en el bucle
				System.out.println("Tienes que indicar m�s de 2 t�rminos. Vuelve a indicarlo...");
			}
			
			
		} while (!numeros_ok);
		
		//como son correctos,llamamos al m�todo
		Utilidades.imprimirFibonacci(num1);
		
		
		

		
		

	}

}
