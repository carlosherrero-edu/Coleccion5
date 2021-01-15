package coleccion5;

import java.util.Scanner;

public class ProbarCifradoCesar {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		String menu = """
				
				 MENÚ DE OPCIONES :
				 -------------------
				 
				 (1) Cifrado de César de una frase
				 (2) Descifrado de César de una frase cifrada
				 (3) Salir
				 """;
		System.out.println(menu);	
		int opcion;
		boolean opcionCorrecta= false;
		do {
			System.out.print( "Elige una opción del menú  >>>");
			opcion = teclado.nextInt();
			if (opcion<1 || opcion>3) {
				System.out.println("Por favor, elige una opción correcta de entre las que presenta el menú");
			} else {
				opcionCorrecta=true;
			}
				
		} while (!opcionCorrecta);
		
		//si la opción es correcta, hacemos el tratamiento que proceda:
		
		switch (opcion) {
			case 1 ->{
				
				System.out.println("Escribe la clave de cifrado (1-25): >>>");
				int clave= teclado.nextInt();
			
				if (clave>=1 && clave <=25){
					Scanner teclado2 = new Scanner(System.in);
					System.out.print("\nEscribe la frase que quieres cifrar, y pulsa Retorno: >>>");
					String textoPlano= teclado2.nextLine();
					String textoCifrado = Utilidades.desplazarLetras(textoPlano, clave);
					System.out.println ("\n El texto cifrado es :"+textoCifrado);
					teclado2.close();
				} else {
					System.out.println("Operación no permitida. La clave debe estar entre 1 y 25");
				}
				
				
				
			}
			case 2 ->{
				
				System.out.print("\n\"Escribe la clave de descifrado (1-25): >>>");
				int clave= teclado.nextInt();
				if (clave>=1 && clave <=25){
					Scanner teclado2 = new Scanner(System.in);
					System.out.print("\nEscribe la frase que deseas descifrar, y pulsa Retorno: >>>");
					String textoCifrado= teclado2.nextLine();
					String textoPlano = Utilidades.desplazarLetras2(textoCifrado, clave);
					System.out.println ("\n El texto plano es :"+textoPlano);
					teclado2.close();
				} else {
					System.out.println("Operación no permitida. La clave debe estar entre 1 y 25");
				}
			}
			case 3 -> 
				System.exit(0); //cerramos el programa
			
		} // fin del switch
		}
		
					
	}


