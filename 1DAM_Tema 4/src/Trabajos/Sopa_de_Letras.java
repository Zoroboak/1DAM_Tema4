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
		int[] auxa; //Variable local que almacena un array
		boolean v = true;//Flag
		
		
		// CABECERA DEL PROGRAMA 
		System.out.println("+-------------------------------------+");
		System.out.println("|                                     |");
		System.out.println("|   Arcade: Piedra, Papel o Tijeras   |");
		System.out.println("|                                     |");
		System.out.println("|  08/01/2019            By Zoroboak  |");
		System.out.println("+-------------------------------------+");
				
		
		do {
			
			System.out.println();
			System.out.println("+---------------------+");
			System.out.println("| 1.- Un Jugador      |");
			System.out.println("| 2.- Dos Jugadores   |");
			System.out.println("| 3.- Opciones        |");
			System.out.println("| 4.- Salir           |");
			System.out.println("+---------------------+");
			
			//Le paso al metodo getDato un String, el parametro que indica lo que 
			//tiene que hacer con el dato, y un array de Strings que no usaremos en este caso
			auxs = "1";
			//Paso el String a entero para trabajar con el
			aux = Integer.parseInt(auxs);
			
			switch(aux) {
			case 1: //1.- Un Jugador
				
			
				
				break;
			case 2: //2.- Dos Jugadores 
				
			
				break;
			case 3: //3.- Opciones    
			
				break;
			case 4: // 4. - SALIR DEL PROGRAMA
				System.out.println();
				System.out.println("Gracias por utilizar este programa. º/(^_^)/º");
				break;
				
			}
			
		}while(aux!=4);
	}
}
