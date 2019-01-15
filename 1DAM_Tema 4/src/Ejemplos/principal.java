package Ejemplos;

import java.util.Scanner;

public class principal {
	
	public static void main(String [] args) {
		
		/* VARIABLES */
		Scanner t = new Scanner(System.in);
		int opc = 0;
		rectangulo rect1 = null;
		
		
		
		do {
			do {
				System.out.println("+-----------------------+");
				System.out.println("|1.-Crear               |");
				System.out.println("|2.-Modificar           |");
				System.out.println("|3.-Mostrar Rectangulos |");
				System.out.println("|4.-Borrar              |");
				System.out.println("+-----------------------+");
				System.out.print("Opción: ");
				opc = t.nextInt();
			}while((opc<0)||(opc>3));
			
			switch(opc) {
				
				case 1:		// OPCIÓN CREAR POR DEFECTO
					rect1 = new rectangulo();
				break;
				
				case 2:		// OPCIÓN CREAR TU PROPIO PÁJARO
					System.out.print("Dame el Alto: ");
					int al = t.nextInt();
					System.out.print("Dame el Ancho ");
					int an = t.nextInt();
					
					rect1 = new rectangulo(al, an);
					
				break;
				
				case 3:
					System.out.println("Hay "+rect1.contar()+" rectangulos");
					
				break;
				
				case 4:		// OPCIÓN BORRAR
					if (rectangulo.contar()!=0) {
						System.out.println("Borramos un Objetos");
						rect1.eliminar();
					}
					
					System.out.println("No quedan rectangulos que borrar");
					
				break;
			}
		}while(opc!=0);
		t.close();
	}

}
