package Trabajos;

import java.util.InputMismatchException;
import java.util.Scanner;

/***
 * Programa: 
 *  Dado un numero entero estrictamente positivo n
 *  
 *  Si es par, se divide entre 2 y si es impar, se multiplica por 3 y se suma 1.
 *  El proceso se repite indefinidamente con el resultado y se detiene si se encuentra el 1
 *  
 *  Por ejemplo, para el 22, la sucesi�n es: 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1
 *  
 *  La conjetura de Collatz (tiene otra infinidad de nombres) dice que, sea cual sea el n�mero de partida, 
 *  antes o despu�s se alcanza el 1. La conjetura a�n no se ha demostrado ni refutado, pero se ha 
 *  comprobado para todos los n�meros menores que 2^60.
 *  
 *  Elabore en primer lugar una funci�n Java de nombre longCiclo que devuelva, para cada entero 
 *  estrictamente positivo n,la cantidad de n�meros que aparece en la sucesi�n hasta encontrar el 1 (extremos inclu�dos).
 *  
 *  Escribir, utilizando esta funci�n, un programa Java que lea por teclado dos n�meros enteros 
 *  estrictamente positivos y escriba en pantalla el valor m�ximo de longCiclo de los n�meros
 *  comprendidos entre los dos dados, ambos inclusive. Utilice en este programa la funci�n longCiclo
 *  
 *  Por ejemplo para los valores de entrada 1 y 5, la salida debe ser 8
 *  
 * 
 *           
 * Autor: Pedro Daniel P�rez S�nchez
 *
 * Fecha: 11/12/2018
 *
 * Materia: Programci�n
 *
 * Curso: 1�DAM
 *
 ***/ 

public class Ejercicio5_longCiclo {
	
	/*Metodo: Mostrar los valores comprendidos entre el minimo y el maximo*/
	public static void getComprendidos(int min, int max) {
		
		for (int i = min; i <= max; i++) {
			System.out.println("N�: "+i+"  Max_lCiclo: "+longCiclo(i));	
		}
	}
	
	/* Metodo longCiclo con las condiciones del enunciado del ejercicio || Devulve las veces que tardo en llegar a 1)*/
	public static int longCiclo(int n) {
	
		int i = 0;//contador
		
		if (n == 1) {
		 i++;
		}else {
			
			while(n!=1){ //Mantener ciclo infinito mientras que n sea diferente de 1
			      if(n%2==0){ //comprobar si n es par
			        // System.out.println("El numero se divide entre 2.");
			        n = n / 2; 
			        i++; //Contador de operaciones +1
			      }
			      else{//si n no es 1, ni es par, entonces tiene que ser impar
			        //System.out.println("El numero se multiplica por 3 y se le suma 1.");
			        n = (n * 3) + 1;
			        i++; //Contador de operaciones +1
			      }
			      if(n==1){ //Si luego del if n ahora vale 1, aumentamos el contador
			        //System.out.println(aux);
			        i++;
			      }
			    }
		}
		return i;//devolvemos las veces que tardo en llegar a 1
	}    
	
	/* Metodo: Validar opci�n del men� */
	public static boolean validaropc(int opc){
		if((opc<0)||(opc>2)){
			System.out.println("Debe escoger una opci�n en el menu");
			return false;
		}
		else{
			return true;
		}
	}
	
	/* M�TODO PRINCIPAL A EJECUTAR */
	public static void main(String[] args) {
		
		/* DECLARACI�N DE VARIABLES DE CABECERA */
		int opc=0;
		Scanner t = new Scanner(System.in);
		
		/* CABECERA DEL PROGRAMA */
		System.out.println("+-------------------------------------+");
		System.out.println("|                                     |");
		System.out.println("|          Metodo longCiclo           |");
		System.out.println("|                                     |");
		System.out.println("+-------------------------------------+");
		
		do{
			do{
				System.out.println();
				System.out.println("+---------------------+");
				System.out.println("| 0.- Salir           |");
				System.out.println("| 1.- Empezar         |");
				System.out.println("| 2.- M�s Informaci�n |");
				System.out.println("+---------------------+");
				System.out.println();
				System.out.print("Elegir una opci�n: ");
				
				try {
					opc = t.nextInt();
				}
				catch (InputMismatchException e) {
					System.out.println("El valor introducido no es valido");
					t.next();
					opc = 3;
				}
				
						
			}while(validaropc(opc)==false);
			
			switch(opc){
				case 1:	// 1.- Programa
					int m;
					try {
						System.out.println();
						System.out.println("Ingrese un n�mero entero estrictamente positivo");
						int n = t.nextInt(); 
						do {
							System.out.println("Ingrese un n�mero entero estrictamente positivo mayor o igual al anterior");
							m = t.nextInt();
						}while(m<n);//Validar que el segundo numero es mayor que el primero
						
						System.out.println("------------------------");
						System.out.println("Numero Minimo: "+n+"   Numero Maximo: "+m);
						System.out.println("------------------------");
						getComprendidos(n, m);
						System.out.println("------------------------");
					}
					catch (Exception e) {
						System.out.println("Algo a fallado, intentelo de nuevo con valores validos �/(^_^)/�");
						t.next();
					}
					System.out.println();
				break;
				
				case 2:	// 2. - M�s Informaci�n
					
					System.out.println();
					System.out.println("Por: Pedro Daniel P�rez S�nchez ");
					System.out.println();
					System.out.println("La conjetura de Collatz (tiene otra infinidad de nombres) dice que, sea cual sea el n�mero de partida,");
					System.out.println("antes o despu�s se alcanza el 1. La conjetura a�n no se ha demostrado ni refutado, pero se ha");
					System.out.println("comprobado para todos los n�meros menores que 2^60.");
					
				break;
				
				case 0:	// SALIR DEL PROGRAMA
					System.out.println();
					System.out.println("Gracias por utilizar este programa. �/(^_^)/�");
				break;
			} 
		
		}while(opc!=0);		
		t.close();
	}
}
