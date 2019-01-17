package Trabajos;

import java.util.Scanner;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

/***
 * Programa: Sopa_de_Letras
 * 
 *           
 * Autor: Pedro Daniel P�rez S�nchezggw
 *
 * Fecha: 08/01/2019
 *
 * Materia: Programci�n
 *
 * Curso: 1�DAM
 *
 ***/ 

public class Sopa_de_Letras {

	
	//Atributos Globales
	//Matriz con los valores de la sopa de letras
	public static char matriz[][] = new char[15][15];
	//Matriz segundaria de validaci�n
	public static boolean bmatriz[][] = new boolean[15][15];

	
	
	
	
	
	//Metodo: pedirle datos al usuario
	public static String getDato(String text,int parametro) {
		/*
		 * Parametro 1: Metodo devuelve un numero dado por el usuario
		 * en el rango [1-4], lo uso para la opci�n del menu
		 * 
		 * El metodo muestra por pantalla el texto que le pasemos 
		 * devuelve un string con la salida validada seg�n el parametro pasado
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
					System.out.println("�El caracter introducido no es valido!");
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
					System.out.println("�La palabra introducida no es valida!");
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
		int num = 0; //Array que contendr� los numeros a devolver
		
		num=(int)Math.floor(Math.random()*(max-min+1)+min);
		
		return num;
	}
	
	//1 � Metodo que recoge las 10 palabras y las devuelve en un string
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
				
				auxsa[i]=getDato("Introduce la "+(i+1)+"� palabra",2);
				
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
	
	//Metodo que organiza las palabras de mayor a menor en un array de strings
	public static String[] mayorAMenor(String[] palabras) {
		
		//Variable local
		String aux = "0"; //variable auxiliar
		
		for(int i=0;i<(palabras.length-1);i++){
            for(int j=i+1;j<palabras.length;j++){
                if(palabras[i].compareToIgnoreCase(palabras[j])<0){
                    //Intercambiamos valores
                    aux=palabras[i];
                    palabras[i]=palabras[j];
                    palabras[j]=aux;

                }
            }
        }
		
		return palabras;
	}
	
	//Metodo que obtiene una orientaci�n aleatoria
	public static int[] orientaci�n() {
		
		//Variables locales
		int[] auxa = {0,0};
		
		//Decidir orientaci�n, 0 derecha a isquierda, 1 isquierda a derecha
		auxa[0]=getAleatorio(0,1);
		
		//Decidir posici�n, 0 vertical, 1 diagonal(X), 2 horizontal, 3 diagonal(Y)
		auxa[1]=getAleatorio(0,3);
		
		//devolver resultados 
		return auxa;
		
	}
	
	//Metodo que coloca la palabra que le pasemos
	public static void colocarPalabra(String palabra) {
		
		//variables locales
		int[] pos = new int [2]; //Almacena posicion
		int[] ori; //Almacena orientaci�n
		
		
		
		//Recorremos la segunda matriz y marcamos las palabras libres y las ocupadas
		for (int i = 0; i < bmatriz.length; i++) {
			for (int j = 0; j < bmatriz.length; j++) {
				if (matriz[i][j]=='-') {
					//Si la cuadricula esta vacia, entonces no estara ocupada
					bmatriz[i][j]=false;
				}else {//Si la matriz tiene algo, entonces estara ocupada
					bmatriz[i][j]=true;
				}
			}
			
		}
		
		//Vemos donde vamos a colocar la palabra y con que orientaci�n
		pos[0]=getAleatorio(0,14);
		pos[1]=getAleatorio(0,14);
		//ori[0] = Decidir orientaci�n, 0 derecha a isquierda, 1 isquierda a derecha
		//ori[1] = Decidir posici�n, 0 vertical, 1 diagonal(X), 2 horizontal, 3 diagonal(Y)
		ori = orientaci�n();
		
		//Comprobamos si hay espacio para colocar nuestra palabra
		int espaciolibre;
		//matriz[pos[0]][pos[1]];
		//ori[0]
		//ori[1]
		
		//switch(
		
		
		
	}
	
	//Metodo que contiene el flujo del juego
	public static void juego() {
		
		//Variables globales
		String[] palabras = new String [10];
		
		
		
		//recorrer la matriz con valor "nulo"(-)
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = '-';
			}
		}
		
		
		//Pedir y guardar las 10 palabras de forma ordenada (Las m�s grande primero)
		palabras = mayorAMenor(get10Palabras());
		
		
		
		
		
		
		
	}
	
	
	//Metodo Principal a Ejecutar
	public static void main(String[] args) {
		/*
		 *  M�TODO PRINCIPAL A EJECUTAR 
		 *  
		 *  Contiene el flujo Global del programa
		 *  
		 *  */
		
		
		// DECLARACI�N DE VARIABLES DE CABECERA 
		int aux = 0; //Variable local que almacena posici�n del menu
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
			auxs = getDato("Escoge opci�n del menu: ",1);
			//Paso el String a entero para trabajar con el
			aux = Integer.parseInt(auxs);
			
			switch(aux) {
			case 1: //1.- Iniciar Juego 
				
				juego();
				
				
				break;
			case 2: //2.- Nivel de Dificultad 
				
			
				break;
			case 3: //3.- Sobre el juego    
				
				
				System.out.println("Pedro Daniel P�rez S�nchez");
				System.out.println();
				
				System.out.println("La sopa de letras es un juego que consiste en descubrir un n�mero determinado");
				System.out.println("de palabras enlazando estas letras de forma horizontal, vertical o diagonal y");
				System.out.println("en cualquier sentido, tanto de derecha a izquierda como de izquierda a ");
				System.out.println("derecha, y tanto de arriba abajo, como de abajo arriba. En el juego vienen ");
				System.out.println("algunas instrucciones o pistas de como encontrar las palabras en todo caso");
				System.out.println("puede venir un listado de palabras las cuales tienes que encontrar.");
				System.out.println();
				
				
				
				break;
			case 4: // 4. - SALIR DEL PROGRAMA
				System.out.println();
				System.out.println("Gracias por utilizar este programa. �/(^_^)/�");
				break;
				
			}
			
		}while(aux!=4);
	}
}
