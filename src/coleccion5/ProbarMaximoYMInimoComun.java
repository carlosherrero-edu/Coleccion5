package coleccion5;

import java.util.Scanner;

public class ProbarMaximoYMInimoComun {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
	
		boolean numeros_ok= false;
		int num1, num2;
		
		do {
			//pediremos valores por teclado hasta que se entreguen números válidos
			
			System.out.print("\n Introduce el primer número -mayor de 0-  >>>");
			num1 = teclado.nextInt();
			
			System.out.print("\n Introduce el segundo número -mayor de 0-  >>>");
			num2 = teclado.nextInt();
			
			if (num1>0 && num2>0) {
				//los números son correctos, salimos del bucle
				numeros_ok=true;
			} else {
				//mostramos un aviso y continuamos en el bucle
				System.out.println("Los números deben ser mayores de 0. Por favor, vuelve a escribirlos...");
			}
			
			
		} while (!numeros_ok);
		
		//como son correctos, mostramos el mcd y el mcm
		System.out.format ("\n\nMáximo común divisor de %d y % d  = %d ", num1, num2, Utilidades.maximoComun(num1, num2));
		System.out.format ("\n\nMínimo común múltiplo de %d y % d  = %d ", num1, num2, Utilidades.minimoComun(num1, num2));
		
		
		

		
		

	}

}
