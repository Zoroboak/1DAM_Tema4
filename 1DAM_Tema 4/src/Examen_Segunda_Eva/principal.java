package Examen_Segunda_Eva;

/*
 * Pedro Daniel Pérez Sánchez
 * 
 *22/02/2019
 * 
 * 
 * */

public class principal {

	public static void main(String[] args) {
		
		//-----1: Mostrar el nombre del autor de las clases
		System.out.println("Examen de Clases");
		System.out.println("Autor: "+sorteo.autor());
		System.out.println();
		
		//-----2: Generar 50 boletos de forma genérica (clase por defecto)
		boleto[] Boletos = new boleto[50];
		
		
		//-----3: Generar 49 boletos de forma fija (generar números al azar y dárselos junto con la fecha al constructor definido por el programación)
		for (int i = 0; i < (Boletos.length-1); i++) {
			Boletos[i] = new boleto();
		}
		
		//-----4: Mostrar al menos 10 boletos de los 99 generados de forma aleatoria.
		for (int i = 0; i < 10; i++) {
			System.out.println("Boleto "+(i+1)+": "+Boletos[i].getNumeros());
		}
		
		
		//-----5: Generar un sorteo (test del constructor)
		sorteo bonoloto = new sorteo();
		
		
		//-----6: Obtener los boletos vendidos para el día del sorteo.
		
		int[] dia = {22};
		int[] dia_boleto = null;
		
		System.out.println("Los boletos del dia "+dia+" son: ");
		
		for (int i = 0; i < Boletos.length; i++) {
			
			 dia_boleto = Boletos[i].getFecha();
			
			if(dia_boleto[0]==dia[0]) {
				System.out.println("Boleto "+(i+1)+": "+Boletos[i].getNumeros());
			}
		}
		
		//-----7: Chequear el sorteo para saber cuantos ganadores hay.
		
		int ganadores = 0;
		int[] temp_boleto;
		int[] temp_num_ganador;
		
		
		for (int i = 0; i < Boletos.length; i++) {
			
			temp_boleto = Boletos[i].getNumeros();
			temp_num_ganador = bonoloto.getResultado();
			
			if(temp_boleto.equals(temp_num_ganador)) {
				
				ganadores++;
			}
			
		}
		
		System.out.println("Hay "+ganadores+" Ganadores");
		
		//-----8: Mostrar el sorteo con los boletos vendidos y los ganadores.s
	}

}
