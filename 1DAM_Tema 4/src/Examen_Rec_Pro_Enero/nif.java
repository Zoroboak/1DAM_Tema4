package Examen_Rec_Pro_Enero;

import java.util.Scanner;

	/*
	 *
	 * Programa que genera un NIF a partir del DNI
	 * 
	 * Autor: Pedro Daniel Pérez Sánchez
	 * 
	 * Fecha: 09/01/2019
	 * 
	 * Descripción: Ejecutas el programa he introduces por consola un DNI, El programa
	 * te devolvera un NIF (DNI+Letra correspondiente) 
	 * 
	 */

public class nif {
	
	//Atributo Global que uso para validar datos
	public static String NIF = "0";
	
	//Metodo para pedirle datos al usuario, se le pasa un string a mostrar por pantalla
	public static int getDato(String text) {
		/*
		 * Metodo que interactua con la consola de comandos
		 * 
		 * Se le pasa un parametro "text" de tipo String que muestra en consola 
		 * cuando va a pedir el dato
		 * 
		 * Si el dato introducido no es correcto, vuelve a pedir datos correctos
		 * 
		 * devuelve el DNI en una variable de tipo entero
		 * 
		 * */
		
		//Variables locales
		String valor = "0";
		boolean v = true;
		int auxn = 0;
		
		
		Scanner t = new Scanner(System.in);
		
		
		do {
			try {
				v=true; //flag a verdadero
				
				//muestro por pantalla el texto que le paso al metodo
				System.out.println(text);
				
				//pido el valor
				valor = t.next();
				
				//Condición de validación
				if(valor.length()!=8) {
					if(valor=="0"){
						v=true;
					}else {
						v = false;
						System.out.println("Debes introducir un DNI de al menos 8 numeros enteros positivos");
					}
					
				}else {//Si todo es correcto, sigo el flujo del programa
					auxn = Integer.parseInt(valor);
					NIF=valor;
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
	
	//Metodo que contiene el flujo del programa
	public static void letraNIF() {
		
		/*
		 * Metodo vacio que ejecuta el flujo del programa
		 * 
		 * Realiza llamadas a otros metodos para interactuar con la consola
		 * 
		 * */
		
		//variables locales
		int aux;
		char letra = '0';
		
		do {
			
			aux = getDato("Introduce un DNI para obtener su letra correspondiente");
			System.out.println("Introduce 0 para salir del programa");
			
			//ejecuto la formula
			aux%=23;
			
			//Tabla de comprobación
			switch(aux) {
			case 0: 
				letra = 'T';
				break;
			case 1: 
				letra = 'R';
				break;
			case 2: 
				letra = 'W';
				break;
			case 3: 
				letra = 'A';
				break;
			case 4: 
				letra = 'G';
				break;
			case 5: 
				letra = 'M';
				break;
			case 6: 
				letra = 'Y';
				break;
			case 7: 
				letra = 'F';
				break;
			case 8: 
				letra = 'P';
				break;
			case 9: 
				letra = 'D';
				break;
			case 10: 
				letra = 'X';
				break;
			case 11: 
				letra = 'B';
				break;
			case 12: 
				letra = 'N';
				break;
			case 13: 
				letra = 'J';
				break;
			case 14: 
				letra = 'Z';
				break;
			case 15: 
				letra = 'S';
				break;
			case 16: 
				letra = 'Q';
				break;
			case 17: 
				letra = 'V';
				break;
			case 18: 
				letra = 'H';
				break;
			case 19: 
				letra = 'L';
				break;
			case 20: 
				letra = 'C';
				break;
			case 21: 
				letra = 'K';
				break;
			case 22: 
				letra = 'E';
				break;
			}
			
			//Mostramos el DNI + su letra
			if(NIF=="0") {
				System.out.println("Gracias por usar el programa");
			}else {
				System.out.print("Su NIF: ");
				System.out.println(NIF+"-"+letra);
			}
			
			
		}while(NIF!="0");
		
	}
	
	/* MÉTODO PRINCIPAL A EJECUTAR */
	public static void main(String[] args) {
		/*
		 * Metodo vacio que realiza la ejecución del programa
		 * 
		 * */
		
		
		System.out.println("-------------------------------------");
		System.out.println("Programa que calcula la letra del NIF");
		System.out.println("-------------------------------------");
		
		
		letraNIF();
		
	}
}
