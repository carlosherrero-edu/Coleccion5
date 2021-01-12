package coleccion5;

import java.util.Scanner;

public class ProbarDevolverCambio {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
	
		boolean cantidad_ok= false;
		double cantidad;
		
		do {
			//pediremos valores por teclado hasta que se entreguen números válidos
			
			System.out.print("\n Introduce el importe en euros del que deseas cambio   >>>");
			cantidad = teclado.nextDouble();
	
			
			if (cantidad>0 && cantidad <10) {
				// el valor es correctto, salimos del bucle
				cantidad_ok=true;
			} else {
				//mostramos un aviso y continuamos en el bucle
				System.out.println("El importe debe ser mayor de 0 e inferior a 10 euros. Vuelve a escribirlo...");
			}
			
			
		} while (!cantidad_ok);
		
		//como son correctos,llamamos al método
		Utilidades.devolverCambio(cantidad);
		
		
		

		
		

	}

}
