package coleccion5;

import java.util.Scanner;

public class ProbarMaximoYMInimoComun {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
	
		boolean numeros_ok= false;
		int num1, num2;
		
		do {
			//pediremos valores por teclado hasta que se entreguen n�meros v�lidos
			
			System.out.print("\n Introduce el primer n�mero -mayor de 0-  >>>");
			num1 = teclado.nextInt();
			
			System.out.print("\n Introduce el segundo n�mero -mayor de 0-  >>>");
			num2 = teclado.nextInt();
			
			if (num1>0 && num2>0) {
				//los n�meros son correctos, salimos del bucle
				numeros_ok=true;
			} else {
				//mostramos un aviso y continuamos en el bucle
				System.out.println("Los n�meros deben ser mayores de 0. Por favor, vuelve a escribirlos...");
			}
			
			
		} while (!numeros_ok);
		
		//como son correctos, mostramos el mcd y el mcm
		System.out.format ("\n\nM�ximo com�n divisor de %d y % d  = %d ", num1, num2, Utilidades.maximoComun(num1, num2));
		System.out.format ("\n\nM�nimo com�n m�ltiplo de %d y % d  = %d ", num1, num2, Utilidades.minimoComun(num1, num2));
		
		
		

		
		

	}

}
