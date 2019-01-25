package Trabajos;

import java.util.Scanner;
/***
 * Programa: Sopa_de_Letras
 * 
 * El programa solo debe pedir 10 palabras y colocarlas en una sopa de letras
 * La sopa de letras tiene un tamaño de 15 x 15 (matriz)
 *           
 * Autor: Pedro Daniel Pérez Sánchez
 *
 * Fecha: 18/01/2019
 *
 * Materia: Programción
 *
 * Curso: 1ºDAM
 *
 ***/ 

public class Sopa_de_Letras {

	
	//Atributos Globales
	//Matriz con los valores de la sopa de letras
	public static char matriz[][] = new char[15][15];
	//Atributo global que define las palabras que se piden por pantalla
	public static int M = 10;
	
	
	
	//Metodo para mostrar la matriz
	public static void mostrarMatriz() {
		//Mostrar Matriz en consola
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	//Metodo para rellenar la matriz de letras aleatorias 
	public static void generarLetras() {
		//Mostrar Matriz en consola
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if(matriz[i][j]=='-') {
					matriz[i][j] = (char) getAleatorio(65,90);
				}
			}
		}
		
	}
	
	
	//Metodo: pedirle datos al usuario
	public static String getDato(String text,int parametro) {
		/*
		 * Parametro 1: Metodo devuelve un numero dado por el usuario
		 * en el rango [1-4], lo uso para la opción del menu
		 * 
		 * Parametro 2: Devuelve la siguiente palabra introducida por el usuario
		 * 
		 * El metodo muestra por pantalla el texto que le pasemos 
		 * devuelve un string con la salida validada según el parametro pasado
		 * 
		 * */
		
		
		//Variables locales del metodo
		String auxs = "-"; //Variable auxiliar que almacena un strings
		int aux = 0; //Variable auxiliar que almacena un valor entero
		boolean v = false; //Flag que marca si el valor es valido o no
		
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
					//Si hay un numero, lo volvemos a pedir
					for (int i = 0; i < auxs.length(); i++) {
						if((auxs.charAt(i)>=48)&&(auxs.charAt(i)<=57)) {
							i=auxs.length();
							System.out.println("Debes introducir una palabra entre 3 y 15 caracteres, no numeros");
							v=false;
							
						}
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
		
		//Paso palabra a mayusculas
		auxs = auxs.toUpperCase();
		
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
		//Variables globales
		String[] auxsa = new String [M];
		
		//Variables Locales
		boolean v = false; //Flag que marca si el valor es valido o no
		
		//flujo del metodo, pido las palabras M veces (por defecto 10)
		for (int i = 0; i < M; i++) {
			
			do {
				//Pongo el flag del while a true
				v=true;
				
				auxsa[i]=getDato("Introduce la "+(i+1)+"º palabra diferente entre 3 y 15 caracteres",2);
				
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
                if(palabras[i].length()<palabras[j].length()){
                    //Intercambiamos valores
                    aux=palabras[i];
                    palabras[i]=palabras[j];
                    palabras[j]=aux;

                }
            }
        }
		
		return palabras;
	}
	
	//Metodo que obtiene una orientación aleatoria
	public static int[] orientación() {
		
		//Variables locales
		int[] auxa = {0,0};
		
		//Decidir orientación, 0 derecha a isquierda, 1 isquierda a derecha
		auxa[0]=getAleatorio(0,1);
		
		//Decidir posición, 0 vertical, 1 diagonal(X), 2 horizontal, 3 diagonal(Y)
		auxa[1]=getAleatorio(0,3);
		
		//devolver resultados 
		return auxa;
		
	}
	
	//Metodo que coloca la palabra que le pasemos
	public static void colocarPalabra(String palabra) {
		
		/*
		 * Metodo que coloca una palabra en una ubicación aleatoria,
		 * con una orientación aleatoria y una posición aleatoria
		 * 
		 * */
		
		//variables locales
		int[] pos = new int [2]; //Almacena posicion
		int[] ori; //Almacena orientación
		boolean v = true; //flag auxiliar
		
		
		//Creamos una copia de la matriz para reestablecerla si hace falta
		char[][] copiamatriz = new char[15][15];
		
		//Copias la matriz
		for(int a=0;a<15;a++) {
			for(int b=0;b<15;b++)
				copiamatriz[a][b] = matriz[a][b];
		}
		
		//Vemos donde vamos a colocar la palabra y con que orientación
		pos[0]=getAleatorio(0,14);
		pos[1]=getAleatorio(0,14);
		//ori[0] = Decidir orientación, 0 derecha a isquierda, 1 isquierda a derecha
		//ori[1] = Decidir posición, 0 vertical, 1 diagonal(X), 2 horizontal, 3 diagonal(Y)
		ori = orientación();
		
		
		//matriz[pos[0]][pos[1]];
		//ori[0] Orientación
		//ori[1] Posición
		
		
		switch(ori[1]) {
		case 0: //Si posición es vertical
			
			do {
				v = true; //flag a positivo
				
				if(ori[0]==0) {//Comprobar palabra de arriba a abajo
					try {
						for (int i = 0; i < palabra.length(); i++) {
							if(matriz[(pos[0]+i)][pos[1]]!='-') {
								//Espacio ocupado
								v = false;
								//Restablecemos la matriz
								for(int a=0;a<15;a++) {
									for(int b=0;b<15;b++)
										matriz[a][b] = copiamatriz[a][b];
								}
							}else {
								//Si esta libre, aprovechamos el for y colocamos la letra de la palabra
								matriz[(pos[0]+i)][pos[1]] = palabra.charAt(i);
							}
						}
					} catch(Exception e){
						
						//Si nos salimos de la matriz, no hay espacio
						v = false;
						
						//Restablecemos la matriz
						for(int a=0;a<15;a++) {
							for(int b=0;b<15;b++)
								matriz[a][b] = copiamatriz[a][b];
						}
						
					}
				}else if(ori[0]==1){//comprobar palabra de abajo a arriba
					try {
						for (int i = 0; i < palabra.length(); i++) {
							if(matriz[(pos[0]-i)][pos[1]]!='-') {
								//Espacio ocupado
								v = false;
								//Restablecemos la matriz
								for(int a=0;a<15;a++) {
									for(int b=0;b<15;b++)
										matriz[a][b] = copiamatriz[a][b];
								}
							}else {
								//Si esta libre, aprovechamos el for y colocamos la letra de la palabra
								matriz[(pos[0]-i)][pos[1]] = palabra.charAt(i);
							}
						}
					} catch(Exception e){
						//Si nos salimos de la matriz, no hay espacio
						v = false;
						
						//Restablecemos la matriz
						for(int a=0;a<15;a++) {
							for(int b=0;b<15;b++)
								matriz[a][b] = copiamatriz[a][b];
						}
					}
					
				}
				
				if(v==false) { //Si no hay espacio, vuelve a generar una posición hasta que haya espacio
					pos[0]=getAleatorio(0,14);
					pos[1]=getAleatorio(0,14);
				}
				
			}while(!v);
			
			
			break;
		case 1: //Si posición es diagonal(x)
			
			do {
				v = true; //flag a positivo
				
				if(ori[0]==0) {//Comprobar palabra de arriba a abajo (Diagonal x)
					try {
						for (int i = 0; i < palabra.length(); i++) {
							if(matriz[(pos[0]+i)][pos[1]+i]!='-') {
								//Espacio ocupado
								v = false;
								//Restablecemos la matriz
								for(int a=0;a<15;a++) {
									for(int b=0;b<15;b++)
										matriz[a][b] = copiamatriz[a][b];
								}
							}else {
								//Si esta libre, aprovechamos el for y colocamos la letra de la palabra
								matriz[(pos[0]+i)][pos[1]+i] = palabra.charAt(i);
							}
							
						}
					} catch(Exception e){
						//Si nos salimos de la matriz, no hay espacio
						v = false;

						//Restablecemos la matriz
						for(int a=0;a<15;a++) {
							for(int b=0;b<15;b++)
								matriz[a][b] = copiamatriz[a][b];
						}
						
					}
				}else if(ori[0]==1){//comprobar palabra de abajo a arriba (Diagonal x)
					try {
						for (int i = 0; i < palabra.length(); i++) {
							if(matriz[(pos[0]-i)][pos[1]-i]!='-') {
								//Espacio ocupado
								v = false;
								//Restablecemos la matriz
								for(int a=0;a<15;a++) {
									for(int b=0;b<15;b++)
										matriz[a][b] = copiamatriz[a][b];
								}
							}else {
								//Si esta libre, aprovechamos el for y colocamos la letra de la palabra
								matriz[(pos[0]-i)][pos[1]-i] = palabra.charAt(i);
							}
						}
					} catch(Exception e){
						//Si nos salimos de la matriz, no hay espacio
						v = false;
						//Restablecemos la matriz
						for(int a=0;a<15;a++) {
							for(int b=0;b<15;b++)
								matriz[a][b] = copiamatriz[a][b];
						}
					}
					
				}
				
				if(v==false) { //Si no hay espacio, vuelve a generar una posición hasta que haya espacio
					pos[0]=getAleatorio(0,14);
					pos[1]=getAleatorio(0,14);
				}
				
			}while(!v);
			
			
			
			break;
		case 2: //Si posición es horizontal
			
			do {
				v = true; //flag a positivo
				
				if(ori[0]==0) {//Comprobar palabra de derecha a isquierda
					try {
						for (int i = 0; i < palabra.length(); i++) {
							if(matriz[(pos[0])][pos[1]+i]!='-') {
								//Espacio ocupado
								v = false;
								//Restablecemos la matriz
								for(int a=0;a<15;a++) {
									for(int b=0;b<15;b++)
										matriz[a][b] = copiamatriz[a][b];
								}
							}else {
								//Si esta libre, aprovechamos el for y colocamos la letra de la palabra
								matriz[(pos[0])][pos[1]+i] = palabra.charAt(i);
							}
						}
					} catch(Exception e){
						//Si nos salimos de la matriz, no hay espacio
						v = false;
						//Restablecemos la matriz
						for(int a=0;a<15;a++) {
							for(int b=0;b<15;b++)
								matriz[a][b] = copiamatriz[a][b];
						}
						
					}
					
				}else if(ori[0]==1){//comprobar palabra de abajo a arriba
					try {
						for (int i = 0; i < palabra.length(); i++) {
							if(matriz[(pos[0])][pos[1]-i]!='-') {
								//Espacio ocupado
								v = false;
								//Restablecemos la matriz
								for(int a=0;a<15;a++) {
									for(int b=0;b<15;b++)
										matriz[a][b] = copiamatriz[a][b];
								}
							}else {
								//Si esta libre, aprovechamos el for y colocamos la letra de la palabra
								matriz[(pos[0])][pos[1]-i] = palabra.charAt(i);
							}
						}
					} catch(Exception e){
						//Si nos salimos de la matriz, no hay espacio
						v = false;
						//Restablecemos la matriz
						for(int a=0;a<15;a++) {
							for(int b=0;b<15;b++)
								matriz[a][b] = copiamatriz[a][b];
						}
						
					}
					
				}
				
				if(v==false) { //Si no hay espacio, vuelve a generar una posición hasta que haya espacio
					pos[0]=getAleatorio(0,14);
					pos[1]=getAleatorio(0,14);
				}
				
			}while(!v);
			
			
			break;
		case 3: //Si posición es diagonal(y)
			
			do {
				v = true; //flag a positivo
				
				if(ori[0]==0) {//Comprobar palabra de arriba a abajo (Diagonal Y)
					try {
						for (int i = 0; i < palabra.length(); i++) {
							if(matriz[(pos[0]+i)][pos[1]-i]!='-') {
								//Espacio ocupado
								v = false;
								//Restablecemos la matriz
								for(int a=0;a<15;a++) {
									for(int b=0;b<15;b++)
										matriz[a][b] = copiamatriz[a][b];
								}
							}else {
								//Si esta libre, aprovechamos el for y colocamos la letra de la palabra
								matriz[(pos[0]+i)][pos[1]-i] = palabra.charAt(i);
							}
						}
					} catch(Exception e){
						//Si nos salimos de la matriz, no hay espacio
						v = false;
						//Restablecemos la matriz
						for(int a=0;a<15;a++) {
							for(int b=0;b<15;b++)
								matriz[a][b] = copiamatriz[a][b];
						}
						
					}
				}else if(ori[0]==1){//comprobar palabra de abajo a arriba (Diagonal Y)
					try {
						for (int i = 0; i < palabra.length(); i++) {
							if(matriz[(pos[0]-i)][pos[1]+i]!='-') {
								//Espacio ocupado
								v = false;
								//Restablecemos la matriz
								for(int a=0;a<15;a++) {
									for(int b=0;b<15;b++)
										matriz[a][b] = copiamatriz[a][b];
								}
							}else {
								//Si esta libre, aprovechamos el for y colocamos la letra de la palabra
								matriz[(pos[0]-i)][pos[1]+i] = palabra.charAt(i);
							}
						}
					} catch(Exception e){
						//Si nos salimos de la matriz, no hay espacio
						v = false;
						//Restablecemos la matriz
						for(int a=0;a<15;a++) {
							for(int b=0;b<15;b++)
								matriz[a][b] = copiamatriz[a][b];
						}
						
					}
					
				}
				
				if(v==false) { //Si no hay espacio, vuelve a generar una posición hasta que haya espacio
					pos[0]=getAleatorio(0,14);
					pos[1]=getAleatorio(0,14);
				}
				
			}while(!v);
			
			
			break;
		}
		
		
		//Salimos del Switch, ya sabemos que la posición actual es valida
		//########################################
		//La palabra ya esta colocada :D
		
		
		
	}
	
	//Metodo que contiene el flujo del juego
	public static void juego(String[] args) {
		
		//recorrer la matriz con valor "nulo"(-)
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = '-';
			}
		}
		
		
		//Pedir y guardar las 10 palabras de forma ordenada (Las más grande primero)
		String[] palabras = mayorAMenor(get10Palabras());
		
		
		//Mostrar las palabras
		System.out.println("-------------------");
		System.out.println("Palabras Ordenadas");
		System.out.println("-------------------");
		for (int i = 0; i < palabras.length; i++) {
			System.out.println(palabras[i]);
		}
		
		//Colocar palabras en tablero
		
		
		for (int i = 0; i < palabras.length; i++) {
			colocarPalabra(palabras[i]); //Me falla el metodo colocar palabras
		}
		// ######## TEST ######## Coloco palabras pasadas como argumentos
		if(args.length > 0){
			try {
				for (int i = 0; i < args.length; i++) {
					colocarPalabra(args[i].toUpperCase());
				}
			}catch(Exception e) {
				System.out.println("Ha Pasado algo");
				System.out.println(e);
			}
		}
		
		
		//Genera letras aleatorias en los espacios vacios
		generarLetras();
		
		//Mostrar Matriz
		System.out.println("-------------------");
		System.out.println("Sopa de Letras");
		System.out.println("-------------------");
		mostrarMatriz();
		
		
		
		
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
		String auxs; //Variable local que almacena un Strins
		
		
		//### TEST ### si hay argumentos, pedimos menos palabras
		if(args.length > 0) {
			M=M-args.length;			
		}
		
		
		// CABECERA DEL PROGRAMA 
		System.out.println("+-------------------------------------+");
		System.out.println("|                                     |");
		System.out.println("|       Programa: Sopa de Letras      |");
		System.out.println("|                                     |");
		System.out.println("|  19/01/2019            By Zoroboak  |");
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
				
				juego(args);
				
				
				break;
			case 2: //2.- Nivel de Dificultad 
				
				System.out.println("Nivel de Dificultad: 1");
				System.out.println("Nota: En proximas actualizaciones habrá más niveles ^^ ");
			
				break;
			case 3: //3.- Sobre el juego    
				
				
				System.out.println("Pedro Daniel Pérez Sánchez");
				System.out.println();
				
				System.out.println("La sopa de letras es un juego que consiste en descubrir un número determinado");
				System.out.println("de palabras enlazando estas letras de forma horizontal, vertical o diagonal y");
				System.out.println("en cualquier sentido, tanto de derecha a izquierda como de izquierda a ");
				System.out.println("derecha, y tanto de arriba abajo, como de abajo arriba. En el juego vienen ");
				System.out.println("algunas instrucciones o pistas de como encontrar las palabras en todo caso");
				System.out.println("puede venir un listado de palabras las cuales tienes que encontrar.");
				System.out.println();
				
				
				
				break;
			case 4: // 4. - SALIR DEL PROGRAMA
				System.out.println();
				System.out.println("Gracias por utilizar este programa. º/(^_^)/º");
				break;
				
			}
			
		}while(aux!=4);
	}
}
