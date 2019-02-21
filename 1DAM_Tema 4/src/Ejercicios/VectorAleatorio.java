package Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

/***
 * Programa: 
 *  MAX = 20
 *  V = Aleatorio -> 1-100
 *  Buscar valores entre [A , B] usuario
 *  
 *  Mostrar valor y posición  
 * 
 *           
 * Autor: Pedro Daniel Pérez Sánchez
 *
 * Fecha: 11/12/2018
 *
 * Materia: Programción
 *
 * Curso: 1ºDAM
 *
 ***/ 

public class VectorAleatorio {
	
	//Metodo: pedirle datos al usuario
	public static int getDato() {
		/*
		 * Cada vez que es llamado este metodo se le pide un dato entero al usuario
		 * 
		 * El metodo devuelve el valor dado por el usuario
		 * 
		 * */
		Scanner t = new Scanner(System.in);
		int n=5;
		try {
			n = t.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("¡El valor introducido no es valido!");
			t.next();
		}
		return n;
	}
	
	//Metodo: generar un vector con n valores aleatorios
	public static int[] getAleatorio(int n) {
		/*
		 * n = numero de valores que queremos generar
		 * 
		 * el metodo devuelve el vector v con los valores generados
		 * 
		 * */
		
		int[] v = new int[n];	
		for (int i = 0; i < 20; i++) {
			v[i] = (int)((Math.random()*100/*Rango*/)+1/*Minimo*/);
			System.out.print(" "+v[i]);
		}
		return v;
	}
	
	/*Metodo: mostrar los valores del vector que se encuentren en el rango*/
	public static void mostrarEnRangoConPosición(int n, int m, int[] v) {
		/*
		 * n = Valor Rango Inferior 
		 * m = Valor Rango Superior
		 * 
		 * v = Vector que se quiere comparar
		 * 
		 * El metodo no devuelve nada dado que solo queremos mostrar en consola
		 * 
		 * */
		System.out.println("Valor\tPosición");
		for (int i = 0; i < v.length; i++) {
			if ((v[i]>n)&&(v[i]<m)) {
				System.out.println(v[i]+"\t"+(i+1));
			}
			
		}			
	}
	
	//metodo burbuja para ordenadar los valores de un vector
	public static int[] ordenarVector(int[] v) {
		
	     int i;
	     boolean flag = true;
	     int temp;
	     int cont=0;
	     do{
	         flag = false;   
	         for( i=0; i<((v.length -1)-cont); i++){
	            if (v[i]>v[i+1]){
				  temp = v[i];
				  v[i] = v[i+1];
				  v[i+1] = temp;
				  flag = true; 
	             } 
	            
	         }
	         cont++;
	     }while (flag);
	     return v;
	  }
	
	//metodo para mostrar todos los valores de un vector en pantalla
	public static void mostrarVector(int[] v) {
		
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i]+" ");
		}
	}
	
	//Metodo: Comprobar si un valor introducido esta dentro del vector introducido
	public static boolean comprobarValor(int valor, int[] v) {
		
		System.out.println("Busqueda con for");
		
		boolean vof=false; // boolenada que nos dice si el valor fue encontrado o no
		int cont=0; //contador local
		int veces=0;
		for (int i = 0; i < v.length; i++) {
			if (v[i]==valor) {
				vof=true;
				cont++;
			}
			veces++;
		}
		
		if (vof) {
			System.out.println("El valor "+valor+" se encuentra dentro del vector "+cont+" veces");
		} else {
			System.out.println("El valor "+valor+" NO se encuentra dentro del vector");
		}
		
		System.out.println("Ciclos del for: "+veces);
		
		return vof;
	}
		
	
	/* MÉTODO PRINCIPAL A EJECUTAR */
	public static void main(String[] args) {
		
		/* DECLARACIÓN DE VARIABLES DE CABECERA */
		int opc=5;
		
		/* CABECERA DEL PROGRAMA */
		System.out.println("+-------------------------------------+");
		System.out.println("|                                     |");
		System.out.println("|          Vector Aleatorio           |");
		System.out.println("|                                     |");
		System.out.println("+-------------------------------------+");
		
		do{
			do{
				System.out.println();
				System.out.println("+---------------------+");
				System.out.println("| 0.- Salir           |");
				System.out.println("| 1.- Empezar         |");
				System.out.println("| 2.- Más Información |");
				System.out.println("+---------------------+");
				System.out.println();
				System.out.print("Elegir una opción: ");
				
				opc = getDato();
				
						
			}while((opc<0)||(opc>2));
			
			switch(opc){
				case 1:	// 1.- Programa
					
					
					int n = 0, m = 0;
					
					System.out.println();
					System.out.print("Vector Creado:");
					
					//Metodo generar 20 numeros aleatorios entre 1-100
					int[] v = getAleatorio(20);
					
					System.out.println();
					System.out.print("Introduce el rango inferior: ");
					n = getDato(); //Pedirle valores a usuario
					
					do { 
						System.out.print("Introduce el rango superior: ");
						m = getDato();
						}while(n>m); //Obligar a que el segundo valor sea mayor que el primero
					
					//Mostrar por pantalla los valores que esten dentro del rango n - m
					mostrarEnRangoConPosición(n, m, v);
					
					//Ordenar vector y luego mostrarlo por pantalla
					System.out.println();
					System.out.println("Vector Ordenado: ");
					v = ordenarVector(v);
					mostrarVector(v);
					System.out.println();
					
					
					System.out.println("Comprobar si un valor esta en el vector: ");
					n = getDato();
					comprobarValor(n, v);
					
					
				break;
				
				case 2:	// 2. - Más Información
					
					System.out.println();
					System.out.println("Por: Pedro Daniel Pérez Sánchez ");
					System.out.println();
					System.out.println("Programa basado en sacar valores aleatorios al mismo tiempo que practicamos con vectores");
					
				break;
				
				case 0:	// SALIR DEL PROGRAMA
					System.out.println();
					System.out.println("Gracias por utilizar este programa. º/(^_^)/º");
				break;
			} 
		
		}while(opc!=0);		
		
	}
}
