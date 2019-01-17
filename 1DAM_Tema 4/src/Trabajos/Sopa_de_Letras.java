package Trabajos;

import java.util.Scanner;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

/***
 * Programa: Sopa_de_Letras
 * 
 *           
 * Autor: Pedro Daniel Pérez Sánchezggw
 *
 * Fecha: 08/01/2019
 *
 * Materia: Programción
 *
 * Curso: 1ºDAM
 *
 ***/ 

public class Sopa_de_Letras {

	
	//Atributos Globales
	public static char matriz[][] = new char[15][15];
	
	//Metodo: pedirle datos al usuario
	public static String getDato(String text,int parametro) {
		/*
		 * Parametro 1: Metodo devuelve un numero dado por el usuario
		 * en el rango [1-4], lo uso para la opción del menu
		 * 
		 * El metodo muestra por pantalla el texto que le pasemos 
		 * devuelve un string con la salida validada según el parametro pasado
		 * 
		 * */
		
		
		//Variables locales del metodo
		String auxs = "-"; //Variable auxiliar que almacena un strings
		int aux = 0; //Variable auxiliar que almacena un valor entero
		boolean v = false; //Flag que marca si el valor es valido o no
		char caracter; //Varibale auxiliar que almacena un caracter
		
		//Declaro el objeto Scanner
		Scanner t = new Scanner(System.in);
		
		switch(parametro) {
		case 1: //Valor a solicitar: Entero positivo del 1 al 4
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Pido un numero entero
					aux = t.nextInt();
					
					//Si el rango no es correcto, repetimos el while
					if(aux<1||aux>4) {
						System.out.println("Debes introducir un numero en el rango [1-4]");
						v=false;
					}
				}
				catch(Exception e){
					System.out.println("¡El caracter introducido no es valido!");
					t.next();
					v=false;
				}
			}while(!v);
			
			auxs = Integer.toString(aux);
			break;
		case 2: //Valor a solicitar: Palabra introducida por el usuario
			do {
				
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Pido una Palabra entre 3 y 15 caracteres
					auxs = t.next();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()<3||auxs.length()>15) {
						System.out.println("Debes introducir una palabra entre 3 y 15 caracteres");
						v=false;
					}
				}
				catch(Exception e){
					System.out.println("¡La palabra introducida no es valida!");
					t.next();
					v=false;
				}
			}while(!v);
			
			break;
			
		
		}
		
		//Devuelvo un String
		return auxs;
	}
	
	//Metodo getAleatorio
	public static int getAleatorio(int min, int max) {
		/*
		 * Metodo que devuelve un valor aleatorio
		 * entre el min y el max que le pasemos
		 * 
		 * */
		
		
		//Variables Locales
		int num = 0; //Array que contendrá los numeros a devolver
		
		num=(int)Math.floor(Math.random()*(max-min+1)+min);
		
		return num;
	}
	
	//1 – Metodo que recoge las 10 palabras y las devuelve en un string
	public static String[] get10Palabras() {
		/*
		 * Metodo que devuelve un vector de String con 10 palabras sin repetir
		 * 
		 * */
		
		
		//Variables Locales
		int aux = 0; //Variable auxiliar que almacena un valor entero
		boolean v = false; //Flag que marca si el valor es valido o no
		String auxs = "-"; //Variable auxiliar que almacena un strings
		String[] auxsa = {"-","-","-","-","-","-","-","-","-","-"}; //Variable auxiliar que almacena un strings
		char caracter; //Varibale auxiliar que almacena un caracter
		
		for (int i = 0; i < 10; i++) {
			
			do {
				//Pongo el flag del while a true
				v=true;
				
				auxsa[i]=getDato("Introduce la "+(i+1)+"º palabra",2);
				
				if(i>0) {
				for (int j = i; j > 0; j--) {
					if(auxsa[i].equals(auxsa[j-1])) {
						System.out.println("Ya introduciste esta palabra");
						v = false;
					}
					
				}
				}
				
			}while(!v);
			
			
		}
		
		
		return auxsa;
	}
	
	//Metodo Principal a Ejecutar
	public static void main(String[] args) {
		/*
		 *  MÉTODO PRINCIPAL A EJECUTAR 
		 *  
		 *  Contiene el flujo Global del programa
		 *  
		 *  */
		
		
		// DECLARACIÓN DE VARIABLES DE CABECERA 
		int aux = 0; //Variable local que almacena posición del menu
		String auxs; //Variable local que almacena un String
		String[] auxsa; //Variable local que almacena un vector de Strings
		int[] auxa; //Variable local que almacena un array
		boolean v = true;//Flag
		
		
		// CABECERA DEL PROGRAMA 
		System.out.println("+-------------------------------------+");
		System.out.println("|                                     |");
		System.out.println("|       Programa: Sopa de Letras      |");
		System.out.println("|                                     |");
		System.out.println("|  17/01/2019            By Zoroboak  |");
		System.out.println("+-------------------------------------+");
				
		
		do {
			
			System.out.println();
			System.out.println("+-------------------------+");
			System.out.println("| 1.- Iniciar Juego       |");
			System.out.println("| 2.- Nivel de Dificultad |");
			System.out.println("| 3.- Sobre el juego      |");
			System.out.println("| 4.- Salir               |");
			System.out.println("+-------------------------+");
			
			//Le paso al metodo getDato un String, el parametro que indica lo que 
			//tiene que hacer con el dato, y un array de Strings que no usaremos en este caso
			auxs = getDato("Escoge opción del menu: ",1);
			//Paso el String a entero para trabajar con el
			aux = Integer.parseInt(auxs);
			
			switch(aux) {
			case 1: //1.- Iniciar Juego 
				
				auxsa = get10Palabras();
				
				for (int i = 0; i < 10; i++) {
					System.out.println(auxsa[i]);
				}
				
				break;
			case 2: //2.- Nivel de Dificultad 
				
			
				break;
			case 3: //3.- Sobre el juego    
			
				break;
			case 4: // 4. - SALIR DEL PROGRAMA
				System.out.println();
				System.out.println("Gracias por utilizar este programa. º/(^_^)/º");
				break;
				
			}
			
		}while(aux!=4);
	}
}
