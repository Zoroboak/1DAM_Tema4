package Examen_Rec_Pro_Enero;

import java.util.Scanner;

	/*
	 *
	 * Programa que obtiene y muestra la fracción irreducible
	 * 
	 * Autor: Pedro Daniel Pérez Sánchez
	 * 
	 * Fecha: 09/01/2019
	 * 
	 * Descripción: Ejecutas el programa he introduces por consola un numero en el rango [0,0001 - 0,9999],
	 * El programa te devolvera la fraccion inrreducible de dicho numero
	 * 
	 */

public class fraccion {
	
	
	//Metodo para pedirle datos al usuario, se le pasa un string a mostrar por pantalla
	public static float getDato(String text) {
		/*
		 * Metodo que interactua con la consola de comandos
		 * 
		 * Se le pasa un parametro "text" de tipo String que muestra en consola 
		 * cuando va a pedir el dato
		 * 
		 * Si el dato introducido no es correcto, vuelve a pedir datos correctos
		 * 
		 * devuelve un numero dado por consola en el rango [0,0001 - 0,9999] 
		 * 
		 * */
		
		//Variables locales
		float valor = 0;
		boolean v = true;
		float auxn = 0;
		
		
		Scanner t = new Scanner(System.in);
		
		
		do {
			try {
				v=true; //flag a verdadero
				
				//muestro por pantalla el texto que le paso al metodo
				System.out.println(text);
				
				//pido el valor
				valor = t.nextFloat();
				
				
				//Condición de validación
				if((valor<0.0001)||(valor>0.9)) {
					System.out.println("Debes introducir un valor en el rango [0.0001 - 0.9999]");
					
				}else {//Si todo es correcto, sigo el flujo del programa
					auxn=valor;
				}
				
			}
			catch(Exception e){
				t.next();
				System.out.println("El caracter introducido no es valido");
				v=false;
			}
		}while(!v);
		
		return auxn;
	}
	
	//Metodo que contiene el flujo del programa freaccion inrreducible
	public static void calfraccion() {
		
		/*
		 * Metodo que contiene el flujo del programa freaccion inrreducible
		 * 
		 * No devuelve ningun valor, interactua directamente con otros metodos 
		 * */
		
		//Variables locales
		
		double x = 0; //Numerador
		double y = 0; //Denominador 
		boolean ne = false; //Flag: Numero Encontrado
		boolean nu = false; //Flag: Numero Encontrado
		int i = 1; //Contador
		int j = 0; //contador 2
		
		//Calculo de la fracción inrreducible 
		
		
		//Pido el valor
			x = getDato("Introduce numero Decimal (rango [0.0001 - 0.9999])");
			
			//Sigo mi formula
			y = 10000;
			x *= y;
		do {
			i=1;
			do {
					
				ne=false; //Pongo el Flag en false por defecto
				
				if((x%i==0)&&(y%i==0)) {
					x/=i;
					y/=i;
				}
				if(i>=2000) {
					ne = true;
				}
				
				i++;
				
			}while(!ne);
			j++;
			if(j>=2000) {
				nu=true;
			}
			
		}while(!nu);
		
		
		System.out.print("La fracción irreducible es: ");
		System.out.println(x+"/"+y);
		
		
		
	}
	
	/* MÉTODO PRINCIPAL A EJECUTAR */
	public static void main(String[] args) {
		/*
		 * Metodo vacio que realiza la ejecución del programa
		 * 
		 * */
		
		
		System.out.println("--------------------------------");
		System.out.println("Programa de fracción Irreducible");
		System.out.println("--------------------------------");
		
		calfraccion();
		
		
	}
}
