package Trabajos;

import java.util.InputMismatchException;
import java.util.Scanner;

/***
 * Programa: Juego Tres en Raya
 * 
 *           
 * Autor: Pedro Daniel Pérez Sánchez
 *
 * Fecha: 31/12/2018
 *
 * Materia: Programción
 *
 * Curso: 1ºDAM
 *
 ***/ 

public class Juego_Tres_en_Raya {
	
	//Atributos Globales
	//Matriz que contendrá el valor de cada posición
	public static char[][] m = {{},{'-','-','-','-'}, {'-','-','-','-'}, {'-','-','-','-'}};
	//Simbolo que usará cada jugador
	static char fplayer1 = 'X';
	static char fplayer2 = 'O';
	
	
	//Metodo: pedirle datos al usuario
	public static int[] getDato(String text,int opc) {
		/*
		 * El metodo devuelve un array de tipo char con el valor del caracter introducido
		 * 
		 * @parametro text //texto a mostrar por pantalla cuando se pide el dato
		 * 
		 * @parametro opc //Opción del tipo de dato que se pide
		 * 
		 * Dato/opc 1: Devuelve Numero entero en el rango [1-3]
		 * 
		 * Dato/opc 2: Devuelve Caracter que si es posible se pasará a mayusculas
		 * 
		 * Dato/opc 3: Devuelve Numero entero en el rango [1-4] (Menu)
		 * 
		 * 
		 * 
		 * */
		Scanner t = new Scanner(System.in);
		
		//Variables locales
		String sValor="0";
		int[] aValor = {'0','0'};
		int nFilas = 0;
		int nColum = 0;
		char Caracter = '0';
		boolean flag=true;
		
		
		switch (opc) {
		case 1: //Dato/opc 1: Devuelve Numero entero en el rango [1-3]
			
			do {
				try {
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Recojo el string en la variable "Valor String"
					sValor = t.next();
					
					//Si la cantidad de valores no es correcta, repetimos el while
					if(sValor.length()!=2) {
						System.out.println("Debes introducir dos numeros en el rango [1-3]");
						nFilas=-1;
					}else {//Si lo es, seguimos con el programa
						
						//Asigno a las filas el primer valor introducido
						nFilas = Character.getNumericValue(sValor.charAt(0));
						//Asigno a las columnas el segundo valor introducido
						nColum = Character.getNumericValue(sValor.charAt(1));
						
						//Si las filas o las columnas tienen valores fuera de rango,
						//se avisara por consola y se repetira el do while
						if((nFilas<1||nFilas>3)||(nColum<1||nColum>3)) {
							System.out.println("¡Valores fuera de rango: ( [1-3][1-3] )!");
							nFilas = -1;
						}
					}
				}
				catch (InputMismatchException e) {
					System.out.println("¡El valor introducido no es valido!");
					t.next();
					nFilas = -1;
				}
			}while(nFilas<1);
			
			//Pasar las filas ya comprobadas a un array
			aValor[0]=nFilas;
			//Pasar las columnas ya comprobadas a otra posición del array
			aValor[1]=nColum;
			
			//Devolver array
			
			break;
		case 2://Dato/opc 2: Devuelve Caracter que si es posible se pasará a mayusculas (Esta en formato int)
			
			do {
				try {
					//poner el flag en true
					flag=true;
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Recojo el string en la variable "Valor String"
					sValor = t.next(); 
					//Pasar String a mayusculas
					sValor = sValor.toUpperCase();
					//Asigno el primer caracter a la variable Caracter
					Caracter = sValor.charAt(0);
					
					//Si el string dado tiene más de un digito, se repite 
					if(sValor.length()>1) {
						System.out.println("¡Solo puedes introducir un caracter!");
						flag = false;
					}
				}
				catch (InputMismatchException e) {
					System.out.println("¡El valor introducido no es valido!");
					t.next();
					flag = false;
				}
			}while(flag=false);
			
			//Asignar el caracter ya comprobado a el primer valor del array
			
			aValor[0] = Caracter;
			
			//Devolver aValor[0]
			
			break;
		case 3: //Dato/opc 3: Devuelve Numero entero en el rango [1-4] (Menu)
			
			do {
				try {
					//Poner la bandera a verdadero
					flag=true;
					//Mostrar texto pasado por pantalla
					System.out.println(text);
					//Recojo el string en la variable "Valor String"
					sValor = t.next();
					//Asigno el primer caracter a mi variable caracter
					Caracter = sValor.charAt(0);
					
					//Si es un valor numerico, sigo con mi programa
					if(Character.isDigit(Caracter)){
						
						//Aprovecho una variable entera para comprobar el rango
						nFilas = Character.getNumericValue(sValor.charAt(0));
						
						//Si el valor numerico esta fuera de rango, lo vuelvo a pedir
						if(nFilas<1||nFilas>4) {
							System.out.println("¡Valor fuera de rango: [1-4]!");
							flag=false;
						}
						
					}else {//Si no es valor numerico, lo vuelvo a pedir
						
						System.out.println("Solo puedes introducir un numero entero");
						System.out.println("Rango: [1-4]");
						flag=false;
					}
				}
				catch (InputMismatchException e) {
					System.out.println("¡El valor introducido no es valido!");
					t.next();
					flag=false;
				}
			}while(flag=false);
			
			//Pasar el digito ya comprobado al array
			aValor[0]=nFilas;//Aqui aprovecho la variable nFilas para guardar la opc del menu
			
			//Devolver array
			break;
		}
		//Devuelvo el valor del array según el programa ejecutado
		return aValor;
	  }
	
	//Metodo 1: para mostrar por pantalla el tablero
	public static void tablero(char[][] matrizdada) {
		/*
		 * Método 1: Impresión por pantalla del tablero con las posiciones de las fichas.
		 * 
		 * @parametro matrizdada
		 * 
		 * Muestra por pantalla el contenido de 
		 * las posiciones de la matriz pasada por parametro
		 * 
		 */
	    
	    //Contador para lineas del juego
	    int l = 1;
	    
	    //Cabecera Guia del Juego
	    System.out.println("F/C  1   2   3");
	    
	    //Añadir Capa superior de división
	    System.out.print("   ");
	    for (int i = 0; i < 3; i++) {
	      System.out.print(" ---");
	    }
	    System.out.println();
	    
	    //Generando Tablero
	    for (int i = 1; i <= 3; i++) {
	      
	      System.out.print(" "+l+" ");
	      
	      //Crear 3 veces seguidas el "| X "
	      for (int o = 1; o <= 3; o++) {
	        System.out.print("| "+matrizdada[i][o]+" ");
	      }
	      //Añadirle al final el "|"
	      System.out.print("|");
	      System.out.println();
	      
	      //añadirle las lineas que separan la siguiente linea del tablero
	      System.out.print("   ");
	      for (int p = 0; p < 3; p++) {
	        System.out.print(" ---");
	      }
	      System.out.println();
	      l++;
	    }
	    
	  }
	  
	//Metodo 2: Solicita posición, comprueba su validez y coloca las fichas
	public static int[] posicion(int fichas, int pasoscambiados, char simbolojugador) {
		 /*
		 *  Método 2: Solicita posición, comprueba su validez y coloca las fichas.
		 * 
		 * @parametro fichas //Importo las fichas restantes
		 * 
		 * @parametro pasoscambiados //Importo los pasos dado
		 * 
		 * @parametro simbolojugador //Se le pasa al metodo el simbolo del jugador
		 * 
		 * Devuelve un array de 2 valores que uso para actualizar los valores
		 * en el metodo juego
		 * 
		 * #### Notas: ######
		 * 
		 *  Este metodo interactua directamente con el usuario, no le deja introducir fichas
		 *  donde el usuario no deberia según las reglas del juego
		 *  
		 *  Al hacerlo todo de forma local siguiendo el flujo del programa, el unico 
		 *  valor que necesita es la ficha del jugador actual y los pasos que ha dado
		 * 
		 */
		  
		  //Variables Locales
		  int f=0,c=0;//Variables Fila y columna 
		  int[] aux = {'0','0'};
		  boolean ocupada = false; //Flag posición ocupada
		  boolean fichaerronea = false;
		  int[] variableposicion = {0,0};
		  
		  
		//Si le quedan fichas, Procedemos con el movimiento del usuario
		    if (fichas>0) {
		    	do {
			    	//Restablecer flag que nos dice si la posición esta ocupada o no
			    	ocupada = false; 
			    	
					//Pedir Fila y Columna en la misma linea
					aux = getDato("Introduce Fila seguido de la Columna: ",1);
					
					//pasamos fila y columna a variables enteras
					f = aux[0];
					c = aux[1];
					
					if (m[f][c]=='-') {//Si la casilla esta vacia entonces pon la ficha
						
						m[f][c] = simbolojugador; //poner la ficha del jugador
						
						if(fichas>0)fichas--;//Restarle la ficha puesta al jugador
						
						
					}else {
						System.out.println("¡Esa posición ya esta ocupada!");
						ocupada = true;
					}
						
			    }while(ocupada);
			}else {
				System.out.println("¡No te quedan Fichas!");
				
				do {
					
					//Pedir Fila y Columna en la misma linea (Ficha a mover)
					aux = getDato("Introduce Fila, seguido de la columna de ficha a mover: ",1);
					
					//Pasamos fila y columna a variables enteras
					f = aux[0];
					c = aux[1];
				
					if(m[f][c]==simbolojugador) {
						m[f][c]='-';
						fichaerronea = false;
					}else{
						System.out.println("¡Esa ficha no la puedes mover!");
						fichaerronea = true;
					}
				}while(fichaerronea);
				
				//Mostrar Tablero					
			    tablero(m);
				
				do {
			    	//Restablecer flag que nos dice si la posición esta ocupada o no
			    	ocupada = false; 
			    	
					//Pedir Fila y Columna en la misma linea (a donde moverse)
					aux = getDato("Introduce Fila, seguido de la columna a donde quieras moverte: ",1);
					
					//pasamos fila y columna a variables enteras
					f = aux[0];
					c = aux[1];
					
					if (m[f][c]=='-') {//Si la casilla esta vacia entonces pon la ficha
						
						m[f][c] = simbolojugador; //poner la ficha del jugador
						if(fichas>0)fichas--;//Restarle la ficha puesta al jugador
						
						//Contador de pasos hasta el empate
						pasoscambiados++;
						
					}else {
						System.out.println("¡Esa posición ya esta ocupada!");
						ocupada = true;
					}
						
			    }while(ocupada);
			}
		    
		    //Devuelvo las fichas restadas y los pasos cambiados al metodo juego
		    variableposicion[0] = fichas;
		    variableposicion[1] = pasoscambiados;
		    
		    return variableposicion;
	  }
	  
	  
	//Metodo 3: ComprobarVictoria, le pasamos como parametro la ficha del jugador
	public static boolean comprobarVictoria(char sj) {
		/*
		 *  Método 3: Chequeo de si hay algún ganador.
		 * 
		 * @parametro sj //simbolojugador
		 * 
		 * Comprueba si hay algún ganador 
		 * le pasamos como parametro la ficha del jugador
		 * 
		 * ###### Notas: ########
		 * 
		 *  Para comprobar las victorias utilizo un sistema de contadores por fila
		 * Si en una fila se ha encontrado 3 veces el mismo simbolo, (sj) 
		 * Entonces el metodo devuelve "true", en caso contrario false
		 * 
		 *  Uso un juego de ciclos for, es importante resetear los contadores cada vez
		 * que se salte de fila o de columna si es el caso
		 * 
		 * 
		 */
		  
		  
		  int contc = 0, contf = 0, cont = 0;
		  boolean v = false;
		  
		  
		  //Comprobar Victoria por Filas y columnas
		  for (int i = 1; i <= 3; i++) {
			  
			  for (int j = 1; j <= 3; j++) {
				  	
				  	//Aprovecho el mismo contador para las filas y para las columnas
					if (m[i][j]==sj) {
						contf++;
					}
					
					if (m[j][i]==sj) {
						contc++;
					}
					
				}
				  
				if(contf>2||contc>2) {
				  v = true;
				}
				//Resetear Contador
				contf=0;
				contc=0;
		   }
		  
		  
		  //Comprobar Victoria por Diagonal (derecha a isquierda)
		  for (int i = 1; i <= 3; i++) {
			if(m[i][i]==sj) {
				cont++;
			}
			
			if(cont>2) {
				  v = true;
				}
			
		}
		//Resetear Contador
			cont=0;
		  
		  	
		  //Comprobar Victoria por Diagonal (isquierda a derecha)
		for (int i = 1; i <= 3; i++) {
			if(m[3-(i-1)][i]==sj) {
				cont++;
			}
			
			if(cont>2) {
				  v = true;
				}
			
		}
		//Resetear Contador
			cont=0;
		  
			return v;
	  }
	  
	  
	//Metodo que contiene la programación del juego
	public static void juego() {
		  /*
		   * Metodo que contiene el flujo del juego, no se le pasa ningun parametro y afecta
		   * directamente a atributos globales
		   * 
		   * No devuelve ningun valor, solo ejecuta el programa del juego
		   * 
		   * */
		  
		  
		  
		//Variables ###########
			boolean t = true; // true = turno player 1 || false = turno player 2
			int pasoscambiados = 0; //Contador de pasos hasta el empate
			int fichasp1 = 3; //fichas player 1
			int fichasp2 = 3; //fichas player 2
			int fichas = 0; //Variable temporal que uso para almacenar las fichas de cada jugador
			char simbolojugador; // X para jugador 1 y O para jugador 2  (por defecto)
			boolean v = false; //victoria si o no #flag
			int aux[];  //Array auxiliar que uso para recoger datos
			
			
			//Flujo del programa ######
			
			do {
			
				//Preguntarse turno
				if (t) { //Si es turno 1 asignamos las variables del jugador 1
					simbolojugador = fplayer1;
					fichas=fichasp1;
				} else {
					simbolojugador = fplayer2;
					fichas=fichasp2;
				}
				
				//Iniciar un Separador
				System.out.println("------------------");
				
				//Mostrar por pantalla en que turno estamos
				if (t) {
					System.out.println("Turno Jugador 1");
				} else {
					System.out.println("Turno Jugador 2");
				}
				
				
				//Mostrar Fichas Restantes
				System.out.println("Te quedan: "+fichas+" Movimiento/s");
				
				if(fichas<=0) System.out.println("Pasos hasta empate: "+(30-pasoscambiados));
				
				//Cerrar Separador
				System.out.println("------------------");
				
				//Mostrar Tablero					
			    tablero(m);
			    
			    //Metodo que solicita la posición, comprueba que es valida y realiza la colocación
				aux = posicion(fichas, pasoscambiados, simbolojugador);
				
				//Actualizo el valor de las variables locales
				fichas = aux[0];
				pasoscambiados = aux[1];
			    
				//Asignamos el valor de la variable auxiliar a la variable real de las fichas
				if (t) {
					fichasp1 = fichas;
					
				}else {
					fichasp2 = fichas;
				}
			    
			    v = comprobarVictoria(simbolojugador); 
			    
			    if(v==false) {
			    	//Pasar de turno
					t = !t;
			    }
			    
			    //Si llega a 30 pasos, victoria es verdadero
			    if(pasoscambiados>30) {
			    	v = true;
			    }
			
			}while(v==false);
		    
			//Mostrar Tablero
			tablero(m);					
			
			if(pasoscambiados>=30) {
				System.out.println("****************************");
				System.out.println("->|30 Pasos|<- Es un Empate");
				System.out.println("****************************");
			}else {
				
				if(t) {
					System.out.println("************************");
					System.out.println("Ha ganado el jugador 1");
					System.out.println("************************");
				}else {
					System.out.println("************************");
					System.out.println("Ha Ganado el jugador 2");
					System.out.println("************************");
				}
	  		}
			
	  }
	  
	//Metodo para resetear la matriz (tablero)
	public static void resetearMatriz() {
		  /*
		   * Este metodo afecta al atributo/matriz global "m"
		   * 
		   * No se le pasa ningun parametro ni devuelve ningun valor
		   * 
		   * Resetea el valor de la matriz al caracter "-"
		   * 
		   * */
		  
		  for (int i = 1; i <= 3; i++) {
				for (int j = 1; j <= 3; j++) {
					m[i][j] = '-';
				}
			}
	  }
	  
	//Cambiar fichas, metodo para cambiar la ficha de cada jugador
	public static void cambiarFichas() {
		  /*
		   * Este metodo cambia el valor del atributo
		   * "fplayerX" por el valor introducido en consola
		   * 
		   * Al ser un atributo global, no devuelve nada
		   * */
		  
		  
		  //Variable auxiliar
		  int[]aux;
		  
		  //Le pido el caracter del jugador 1 a travez del parametro 2 de getDato (Caracter Mayusculas)
		  aux = getDato("Introduce Caracter que será la ficha del Jugador 1",2);
		  
		  //Le asigno el valor del caracter al atributo especificandole el tipo de dato almacenado
		  fplayer1 = (char)aux[0];
		  
		  
		  //Le obligo al usuario a que introduzca el segundo dato, diferente al primero
		  do {
			  aux = getDato("Introduce Caracter que será la ficha del Jugador 2",2);
			  
			  fplayer2 = (char)aux[0];
			  if(fplayer1==fplayer2) {
				  System.out.println("La ficha no puede ser igual a la del player 1");
			  }
		  }while(fplayer1==fplayer2);
		  
		  //Muestro por pantalla los valores asignados
		  System.out.println("Player 1 jugara con: "+fplayer1);
		  System.out.println("Player 2 jugara con: "+fplayer2);
	  }
	
	/* MÉTODO PRINCIPAL A EJECUTAR */
	public static void main(String[] args) {
		/*
		 *  MÉTODO PRINCIPAL A EJECUTAR 
		 *  
		 *  Contiene el flujo Global del programa
		 *  
		 *  */
		
		
		// DECLARACIÓN DE VARIABLES DE CABECERA 
		int opc=0;
		int[] aux;
		
		// CABECERA DEL PROGRAMA 
		System.out.println("+-------------------------------------+");
		System.out.println("|                                     |");
		System.out.println("|          Juego Tres en Raya         |");
		System.out.println("|                                     |");
		System.out.println("|  30/12/2018            By Zoroboak  |");
		System.out.println("+-------------------------------------+");
		
		do{
			do{
				System.out.println();
				System.out.println("+---------------------+");
				System.out.println("| 1.- Empezar         |");
				System.out.println("| 2.- Instrucciones   |");
				System.out.println("| 3.- Cambiar Fichas  |");
				System.out.println("| 4.- Salir           |");
				System.out.println("+---------------------+");
				System.out.println();
				
				
				//Pedir Opción del menu
				aux = getDato("Elegir una opción: ",3);
				
				//pasamos fila y columna a variables enteras
				opc = aux[0];
						
			}while((opc<1)||(opc>4));
			
			switch(opc){
			
				case 1:	// 1.- Programa
					
					//Correr el Programa del Juego
					juego();
					//Vaciar Matriz al acabar el juego
					resetearMatriz();
					
					
				break;
				case 2:	// 2. - Instrucciones
					
					System.out.println();
					System.out.println("Por: Pedro Daniel Pérez Sánchez ");
					System.out.println();
					System.out.println("Instrucciones:");
				    System.out.println("Cada jugador tiene 3 Fichas y las colocarán en el tablero.");
				    System.out.println("Cuando hayan colocado todas las fichas, las moverán por el");
				    System.out.println("tablero hasta que uno de los dos consiga el tres en raya o");
				    System.out.println("se realicen 30 movimientos.");
				    System.out.println();
				    System.out.println();
					
				break;
				case 3:	// 3. - Cambiar Fichas
					
					//Metodo para cambiar las fichas de cada jugador
					cambiarFichas();
					
					
				break;
				case 4:	// 4. - SALIR DEL PROGRAMA
					System.out.println();
					System.out.println("Gracias por utilizar este programa. º/(^_^)/º");
				break;
			} 
		
		}while(opc!=4);		
		
	}
}
