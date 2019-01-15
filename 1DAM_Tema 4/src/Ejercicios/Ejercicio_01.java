package Ejercicios;

import java.util.Scanner;

public class Ejercicio_01 {

	
	final static int MAX=10; //	NUMERO DE POSICIONES DEL ARRAY
	
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		float[] notas = new float[MAX];
		
		System.out.println("----------------");
		System.out.println("Calculo de media");
		System.out.println("----------------");
		System.out.println();
		
		
		//RECOJO LAS NOTAS
		for (int i = 0; i < MAX; i++) {
			do {
				try {
					System.out.println("Introducir nota "+(i+1)+": ");
					notas[i] = t.nextFloat();
					
					
				} catch (Exception e) {
					System.out.println("Valor Introducido es incorrecto");
					t.next();
					notas[i] = -1;
					
				}
			}while((notas[i]<0)||(notas[i]>10.0));
			
		}
		//MUESTRO LAS NOTAS
		
		for (int i = 0; i < MAX; i++) {
			System.out.println("Nota "+(i+1)+": "+notas[i]);
		}
			
		//CALCULO LAS NOTAS
		float media = 0;
		for (int i = 0; i < MAX; i++) {
			media += notas[i];
		}
		System.out.println("La media es "+ media/MAX);
			
			
			
		
		
		
	}
}
