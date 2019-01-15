package Trabajos;

import java.util.Scanner;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

/***
 * Programa: Arcade_Piedra_Papel_Tijeras
 * 
 *           
 * Autor: Pedro Daniel Pérez Sánchez
 *
 * Fecha: 08/01/2019oerfop
 *
 * Materia: Programción
 *
 * Curso: 1ºDAM
 *
 ***/ 

public class Arcade_Piedra_Papel_Tijeras {

	
	//Atributos Globales
	public static char controlesp1[] = {'q','w','e'};  //Controles Player 1 
	public static char controlesp2[] = {'1','2','3'};  //Controles Player 2
	public static int dificultad = 1; //1 Facil, 2 medio, 3 Dificil
	
	//Metodo para pedirle datos al usuario por pantalla,
	//parametro 1 menu, parametro 2, reconocer ficha del jugador
	public static String getDato(String text,int parametro, char[] controles) {
		
		/*
		 * El metodo devuelve un array de tipo String con el valor del caracter introducido
		 * 
		 * @parametro text //texto a mostrar por pantalla cuando se pide el dato
		 * 
		 * @parametro parametro //opción con el que decimos el tipo de dato que se pide
		 * 
		 * Parametro 1: Devuelve Numero entero en el rango [1-4] (Menu)
		 * 
		 * Parametro 2: obliga al jugador a introducir una jugada. 
		 * solo acepta los controles de ese jugador, devuelve la opción del jugador en un string
		 * 
		 * Parametro 3: Pide un caracter por consola, se asegura de que solo sea uno y lo devuelve
		 * 
		 * 
		 * 
		 * */
		
		//Variables Locales
		int aux = 0; //Variable auxiliar que almacena un valor entero
		boolean v = false; //Flag que marca si el valor es valido o no
		String auxs = "-"; //Variable auxiliar que almacena un strings
		char caracter; //Varibale auxiliar que almacena un caracter
		
		
		//Declaro el objeto Scanner
		Scanner t = new Scanner(System.in);
		
		
		switch(parametro) {
		case 1: 
			
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
				catch (InputMismatchException e) {
					System.out.println("¡El caracter introducido no es valido!");
					t.next();
					v=false;
				}
			}while(v=false);
			
			auxs = Integer.toString(aux);
			
			break;
		case 2: 
			
			do {
				try {
					
					//Doy por supuesto que el valor introducido es correcto
					v = true; 
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Pido un caracter
					auxs = t.next();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()!=1) {
						System.out.println("Solo puedes introducir un caracter de tus controles");
						v=false;
					}else {//Seguimos con el flujo del programa
						
						//Tomo el primer Caracter de la variable
						caracter = auxs.charAt(0);
						
						//Compruebo que sea el caracter del control y si lo es lo asigno a su valor de jugada
						if(caracter==controles[0]||caracter==controles[1]||caracter==controles[2]) {
							if(caracter==controles[0]){
								auxs = "Piedra";
							}else if(caracter==controles[1]) {
								auxs = "Papel";
							}else if(caracter==controles[2]) {
								auxs = "Tijeras";
							}
						}else {
							System.out.println("¡El caracter introducido no es valido!");
							v=false;
						}
						
					}
				}
				catch (InputMismatchException e) {
					System.out.println("¡El caracter introducido no es valido!");
					t.next();
					v=false;
				}
			}while(!v);
			
			
			break;
		case 3:
			
			do {
				try {
					//Doy por supuesto que el valor introducido es correcto
					v = true;
					
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					
					//Pido un caracter
					auxs = (String) t.next();
					
					//Si el rango no es correcto, repetimos el while
					if(auxs.length()!=1) {
						System.out.println("Solo puedes introducir un caracter");
						v=false;
					}
					
				}
				catch(Exception e) {
					System.out.println("¡El caracter introducido no es valido!");
					t.next();
					v=false;
				}
				
			}while(!v);
			
			
			break;
		
		}
		
		//Devuelvo un String
		return auxs;
	}
	
	//Metodo que optiene un valor aleatorio, 
	//Prametros: Minimo,Maximo,Parametro (1 con repetición, 2 sin repetición ),Tamaño del array 0
	public static int[] getAleatorio(int min, int max, int parametro, int tamaño) {
		
		/*
		 * Metodo que optiene un valor aleatorio, sus parametros son: 
		 * 
		 * min: Valor minimo del rango
		 * 
		 * max: Valor maximo del rango
		 * 
		 * parametro: Tipo de aleatorio, 1 con repetición y 2 sin repetición
		 * 
		 * tamaño: tamaño del vector que devuelve (cantidad de digitos)
		 * 
		 * */
		
		
		//Variables Locales
		int[] num = {0,0,0,0,0}; //Array que contendrá los numeros a devolver
		
		
		switch(parametro) {
		case 1: //Metodo que devuelve un numero aleatorio entre un maximo y un minimo
			num[0]=(int)Math.floor(Math.random()*(max-min+1)+min);
			
			break;
		case 2: //Metodo que devuelve un array de numeros aleatorios sin repetirse
			
			Set<Integer> numeros = new HashSet<>();

			for(;numeros.size() < tamaño;) {
			    int numero = (int) (Math.random()*(max-min+1) + min);
			    //if(!numeros.add(numero)) System.out.println(numero + " descartado por estar repetido."); 
			    numeros.add(numero);
			}
			
			//System.out.println("Los números escogidos son: " + numeros);
		    
		    //No consegui pasar la arrayList "numeros" a un array, asi que lo hago a mano
		    int i=0;
			for (Integer integer : numeros) {
				num[i] = (int) integer;
				i++;
			}
		    
			break;
		}
		
		
		return num;
	}
	
	//Metodo que devuelve una jugada aleatoria entre "Pieda" "Papel" o "Tijeras"
	public static String getJugadaAleatoria() {
		
		/*
		 * No se le pasa ningun parametro, solo devuelve
		 * el string con el valor de la jugada aleatoria
		 * 
		 * */
		
		
		int[] auxa = {0}; //Variable auxiliar, array que uso para almacenar datos
		String Jugada = "Pieda"; //Le asigno un valor por defecto
		
		auxa = getAleatorio(0,2,1,0); //Minimo, Maximo, Aleatorio con repetición, tamaño array 0
		
		switch(auxa[0]) {
		case 0:
			Jugada = "Piedra";
			break;
		case 1: 
			Jugada = "Papel";
			break;
		case 2: 
			Jugada = "Tijeras";
			break;
		}
				
		return Jugada;
	}
	
	//Metodo que invierte la jugada, Si le pones Piedra te saca Papel, si le pones Papel te saca Tijeras, etc
	public static String invertirJugada(String Jugadap1) {
		
		/*
		 * A este metodo se le pasa como parametro la jugada que queremos invertir
		 * 
		 * si le pasamos el String "Piedra" devolvera el String "Papel"
		 * 
		 * Solo tiene 3 parametros: "Piedra" "Papel" y "Tijeras"
		 * 
		 * */
		
		String contrajugada = "Piedra";
		
		switch(Jugadap1) {
		case "Piedra":
			contrajugada = "Papel";
			break;
		case "Papel": 
			contrajugada = "Tijeras";
			break;
		case "Tijeras": 
			contrajugada = "Piedra";
			break;
		}
		
		return contrajugada;
		
	}
	
	//Metodo que comprueba si hay empate o victoria, si hay victoria nos dice quien es el ganador
	public static int comprobarVictoria(String jugadap1, String jugadap2) {
		
		/*
		 * Metodo que comprueba si hay empate o victoria, si hay victoria nos dice quien es el ganador
		 * 
		 * @parametro jugadap1 //Le pasamos la jugada del jugador 1
		 * 
		 * @parametro jugadap2 //Le pasamos la jugada del jugador 2
		 * 
		 * El metodo devuelve un valor entero
		 * 
		 * 0 para empate, 1 para vitoria del jugador 1 y 2 para victoria del jugador 2
		 * 
		 * */
		
		
		int ganador = 2; //Por defecto gana el player 2
		
		//Compruebo si es empate
		if(jugadap1==jugadap2) {
			ganador=0;
		}else {//Si no lo es, sigo con el programa
			//Pongo solo los casos en que ganaria P1, el resto de los casos gana P2
			if(jugadap1=="Piedra"&&jugadap2=="Tijeras") {
				ganador = 1;
			}else if(jugadap1=="Papel"&&jugadap2=="Piedra") {
				ganador = 1;
			}else if(jugadap1=="Tijeras"&&jugadap2=="Papel") {
				ganador = 1;
			}
		}
		
		return ganador;
	}
	
	//Metodo que tiene el flujo del juego para 1 jugador y para 2 jugadores
	public static void Juego(int Mode) {
		
		/*
		 * El metodo en si, no devuelve nada,
		 * trabaja directamente sobre la consola he interactua con atributos globales
		 * 
		 * @parametro Mode: 1 para un jugador, 2 para dos jugadores
		 * 
		 * */
		
		
		//Variables locales
		String[] Jugadap1 = new String[5]; //Aqui Almaceno las jugada según el turno
		String[] Jugadap2 = new String[5]; //Aqui Almaceno las jugada según el turno 
		boolean t = true; //True para turno jugador 1 y false para turno jugador 2
		int ronda = 0; //Almaceno la ronda en la que estoy
		String[] aux = {"-"}; //String Auxiliar para almacenar datos 
		int victoriasp1 = 0, victoriasp2 = 0; //Almaceno las victorias de cada jugador
		int rondasafectadas = 0; //variable que decide las rondas que ganara si o si el jugador 2
		int[] rondaselegidas = {0,0,0,0,0}; //Variable que contendra las rondas que el programa va a afectar
		String auxs = "0"; //String que uso como variable auxiliar
		int v = 0; //Flag que me dice si hay victoria
		
		
		switch(Mode) {
		case 1: 
			//Juego 1 Jugador
			
			
			//Le asigno por defecto todos los movimientos aleatorios al jugador 2
			for(int i=0; i<=4; i++){
				Jugadap2[i] = getJugadaAleatoria();
			}
			
			//NOTA: El for anterior decide las jugadas por defecto del jugador 2
			
			
			//Dependiendo de la dificultad 
			switch(dificultad){
			case 1: //Todas las Jugadas, Aleatorias
				rondasafectadas = 0;
				break;
			case 2: //3 Jugadas seran aleatorias, el resto derrota
				rondasafectadas = 2;
				break;
			case 3: // 1 jugada será aleatoria, el resto derrota
				rondasafectadas = 4;
				break;
			}
			
			
			//Segun la dificultad, escojo las rondas que fallara el jugador por desición del algoritmo
			rondaselegidas = getAleatorio(0,4,2,rondasafectadas); 
			
			///Asigno las jugadas vencedoras si o si a las fichas del jugador 2
			for(int i=0; i<(rondaselegidas.length-1); i++ ) {
				Jugadap2[rondaselegidas[i]] = "Joker";
			}
			
			
			
			//Flujo del juego       #################### ########### #########
			for(ronda=0; ronda<5; ronda++){
				do {//Repito el ciclo siempre que haya un empate
					
					//Pongo a 0 el flag
					v = 0;
					
					//Inicio separador
					System.out.println("---------------------------------------------------");
					
					//Muestro ronda y turno
					System.out.println("Ronda: "+ronda+"      Jugador 1: "+victoriasp1+"       Jugador 2: "+victoriasp2);
					System.out.println("Turno Jugador 1");
					
					//Cierro separador
					System.out.println("---------------------------------------------------");
	
					//Le pregunto al jugador que va a sacar
					auxs = getDato("Escoja Piedra("+controlesp1[0]+"), Papel("+controlesp1[1]+") o Tijera("+controlesp1[2]+")",2, controlesp1);
					
					
					//Guardo la jugada del juegador en su variable
					Jugadap1[ronda] = auxs;
					
					//Le digo que escogio
					System.out.println("Jugaste "+Jugadap1[ronda]);
					
					//Le hago perder si es una ronda elegida
					if(Jugadap2[ronda]=="Joker"){
						Jugadap2[ronda] = (String) invertirJugada(Jugadap1[ronda]);
						//System.out.println("##########Te hago perder########");
					}
					
					//Le digo que su oponente ya jugó
					System.out.println("Jugador 2 a escogido "+Jugadap2[ronda]);
					System.out.println();
					
					//Miro quien gano
					v = comprobarVictoria(Jugadap1[ronda],Jugadap2[ronda]);
					
					//Aviso por pantalla si es empate
					if(v==0) {
						System.out.println("Ha sido Empate, se vuelve a intentar");
						//Si es empate, hago que el jugador 2 juegue la ficha contraria
						Jugadap2[ronda] = (String) invertirJugada(Jugadap2[ronda]);
					}
					
				}while(v==0);
				
				//Muestro ganador
				if(v==1){
					System.out.println("* Gana el player 1 con "+Jugadap1[ronda]);
					victoriasp1++;

				}else{
					System.out.println("* Gana el player 2 con "+Jugadap2[ronda]);
					victoriasp2++;
				}

			}
			
			//Han pasado las 5 rondas
			System.out.println();
			System.out.println("*********************************");
			System.out.println("Pasaron 5 Rondas, Tenemos ganador");
			
			if(victoriasp1>victoriasp2){
				System.out.println("Gana el Jugador 1 con "+victoriasp1+" rondas ganadas");
			}else{
				System.out.println("Gana el Jugador 2 con "+victoriasp2+" rondas ganadas");
			}
			System.out.println("+-------");
			System.out.println("Rondas Ganadas:");
			System.out.println("Player 1: "+victoriasp1+" Rondas de 5");
			System.out.println("Player 2: "+victoriasp2+" Rondas de 5");
			System.out.println("+-------");
			
			break;
		case 2: 
			//Juego 2 Jugadores
			
			//Flujo del juego       #################### #########
			for(ronda=0; ronda<5; ronda++){
				do {//Repito el ciclo siempre que haya un empate
					
					//Pongo a 0 el flag
					v = 0;
					
					//Inicio separador
					System.out.println("---------------------------------------------------");
					
					//Muestro ronda y turno
					System.out.println("Ronda: "+ronda+"      Jugador 1: "+victoriasp1+"       Jugador 2: "+victoriasp2);
					
					//Cierro separador
					System.out.println("---------------------------------------------------");
	
					//Le pregunto al jugador 1 que va a sacar
					auxs = getDato("Jugador 1: Escoja Piedra("+controlesp1[0]+"), Papel("+controlesp1[1]+") o Tijera("+controlesp1[2]+")",2, controlesp1);
					
					//Guardo la jugada del juegador en su variable
					Jugadap1[ronda] = auxs;
					
					//Le pregunto al jugador 2 que va a sacar
					auxs = getDato("Jugador 2: Escoja Piedra("+controlesp2[0]+"), Papel("+controlesp2[1]+") o Tijera("+controlesp2[2]+")",2, controlesp2);
					
					//Guardo la jugada del juegador en su variable
					Jugadap2[ronda] = auxs;
					
					//Digo que escogio el Jugador 1
					System.out.println("Jugador 1 usó: "+Jugadap1[ronda]);
					
					//Digo que escogio el Jugador 2
					System.out.println("Jugador 2 usó: "+Jugadap2[ronda]);
					
					
					//Miro quien gano
					v = comprobarVictoria(Jugadap1[ronda],Jugadap2[ronda]);
					
					//Aviso por pantalla si es empate
					if(v==0) {
						System.out.println("Ha sido Empate, se vuelve a intentar");
						//Si es empate, hago que el jugador 2 juegue la ficha contraria
						Jugadap2[ronda] = (String) invertirJugada(Jugadap2[ronda]);
					}
					
				}while(v==0);
				
				//Muestro ganador
				if(v==1){
					System.out.println("* Gana el player 1 con "+Jugadap1[ronda]);
					victoriasp1++;

				}else{
					System.out.println("* Gana el player 2 con "+Jugadap2[ronda]);
					victoriasp2++;
				}

			}
			
			//Han pasado las 5 rondas
			System.out.println();
			System.out.println("*********************************");
			System.out.println("Pasaron 5 Rondas, Tenemos ganador");
			
			if(victoriasp1>victoriasp2){
				System.out.println("Gana el Jugador 1 con "+victoriasp1+" rondas ganadas");
			}else{
				System.out.println("Gana el Jugador 2 con "+victoriasp2+" rondas ganadas");
			}
			System.out.println("+-------");
			System.out.println("Rondas Ganadas:");
			System.out.println("Player 1: "+victoriasp1+" Rondas de 5");
			System.out.println("Player 2: "+victoriasp2+" Rondas de 5");
			System.out.println("+-------");
			
			break;
		}
		
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
			auxs = getDato(" ",1, controlesp1);
			//Paso el String a entero para trabajar con el
			aux = Integer.parseInt(auxs);
			
			switch(aux) {
			case 1: //1.- Un Jugador
				
				Juego(1);
				
				break;
			case 2: //2.- Dos Jugadores 
				
				Juego(2);
				
				break;
			case 3: //3.- Opciones    
				
				do {
					System.out.println();
					System.out.println("+-----------------------------------------+");
					System.out.println("| ...Menu Opciones:                       |");
					System.out.println("|                                         |");
					System.out.println("| 1.- Controles del Jugador 1             |");
					System.out.println("| 2.- Controles del Jugador 2             |");
					System.out.println("| 3.- Nivel de dificultad para un Jugador |");
					System.out.println("| 4.- Volver al Menu Principal            |");
					System.out.println("+-----------------------------------------+");
					
					//Le paso al metodo getDato un String, el parametro que indica lo que 
					//tiene que hacer con el dato, y un array de Strings que no usaremos en este caso
					auxs = getDato(" ",1, controlesp1);
					//Paso el String a entero para trabajar con el
					aux = Integer.parseInt(auxs);
					
					switch(aux) {
					case 1: //1.- Controles del Jugador 1  
						
						do {
							v = true; //Flag
							auxs = getDato("Introduce el control para Piedra",3,controlesp1);
							controlesp1[0] = auxs.charAt(0);
							auxs = getDato("Introduce el control para Papel",3,controlesp1);
							controlesp1[1] = auxs.charAt(0);
							auxs = getDato("Introduce el control para Tijeras",3,controlesp1);
							controlesp1[2] = auxs.charAt(0);
							
							//Compruebo que los controles no sean iguales
							for (int i = 0; i < 3; i++) {
								if(controlesp1[i]==controlesp2[i]) {
									v = false;
								}
							}
							//Si lo son, los vuelvo a pedir
							if(!v) System.out.println("No puedes tener los mismos controles que tu oponente");
						}while(!v);
						
						System.out.println();
						System.out.println("Tus nuevos controles son: ");
						System.out.println("Piedra("+controlesp1[0]+"), Papel("+controlesp1[1]+") o Tijera("+controlesp1[2]+")");
						
						break;
					case 2: //2.- Controles del Jugador 2 
					
						do {
							v = true; //Flag
							auxs = getDato("Introduce el control para Piedra",3,controlesp1);
							controlesp2[0] = auxs.charAt(0);
							auxs = getDato("Introduce el control para Papel",3,controlesp1);
							controlesp2[1] = auxs.charAt(0);
							auxs = getDato("Introduce el control para Tijeras",3,controlesp1);
							controlesp2[2] = auxs.charAt(0);
							
							//Compruebo que los controles no sean iguales
							for (int i = 0; i < 3; i++) {
								if(controlesp1[i]==controlesp2[i]) {
									v = false;
								}
							}
							//Si lo son, los vuelvo a pedir
							if(!v) System.out.println("No puedes tener los mismos controles que tu oponente");
						}while(!v);
						
						System.out.println();
						System.out.println("Tus nuevos controles son: ");
						System.out.println("Piedra("+controlesp2[0]+"), Papel("+controlesp2[1]+") o Tijera("+controlesp2[2]+")");
						
						
						break;
					case 3: //3.- Nivel de dificultad para un Jugador  
						
						do {
							auxs = getDato("Escoge dificultad [1-3]",1,controlesp1);
							
							//Paso el String a entero para trabajar con el
							aux = Integer.parseInt(auxs);
							
						}while((aux>3||aux<1)==true);
						
						//Si el numero se encuentra entre 1-3, lo tomo como valor de dificultad
						dificultad = aux;
						
						System.out.println("Dificultad actual: "+dificultad);
						
						break;
					case 4: // 4. - Volver al Menu Principal
						System.out.println();
						System.out.println("*Menu Principal*");
						break;
						
					}
					
				}while(aux!=4);
				//Reseteamos el valor de la variable auxiliar para evitar conflictos
				aux=0;
				
				break;
			case 4: // 4. - SALIR DEL PROGRAMA
				System.out.println();
				System.out.println("Gracias por utilizar este programa. º/(^_^)/º");
				break;
				
			}
			
		}while(aux!=4);
	}
}
