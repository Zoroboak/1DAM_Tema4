package TrabajosConClases;

/*
 * Pedro Daniel Pérez Sánchez
 * 
 * Trabajos Con Clases
 * 
 * 20/11/2018
 *  
 *  */

import java.util.Scanner;

public class principal {

	public static int menu() {
		int opc = 0;
		Scanner t = new Scanner(System.in);

		do {
			try {
				System.out.println("+--------------------------------+");
				System.out.println("| 0.Salir                        |");
				System.out.println("| 1.Crear Objeto rectángulo      |");
				System.out.println("| 2.Crear Objeto círculo         |");
				System.out.println("| 3.Crear Objeto triángulo       |");
				System.out.println("| 4.Calcular el perímetro        |");
				System.out.println("| 5.Calcular el área             |");
				System.out.println("+--------------------------------+");
				opc = t.nextInt();
			} catch (Exception e) {
				t.next();
			}
		} while ((opc < 0) || (opc > 5));

		return opc;
	}

	public static void main(String[] args) {

		//DECLARACIÓN DE VARIABLES
		Scanner t = new Scanner(System.in);
		int opc;
		int a, b, c, d, r;  //VARIABLES CONTROL DE OPCIONES DEL MENU
		double area = 0;
		double auxiliarAr = area;
		double acirculo;

		//CREACIÓN DE LOS OBJETOS
		rectangulo rectanguloObj = new rectangulo();
		circulo circuloObj = new circulo();
		triangulo trianguloObj = new triangulo();

		
		//INICIO DEL MENU (REUTILIZADO Y MODIFICADO DE OTROS EJERCICIOS)
		do {
			opc = menu();
			switch (opc) {
			case 1:

				do {
					//CREACIÓN DE UN RECTANGULO
					//OJO: IMPORTANTE, SIEMPRE USAR TRY Y CATCH
					try {
						System.out.println("Crear Rectangulo: ");
						System.out.print("Introducir Alto: ");
						a = t.nextInt();
						rectanguloObj = rectanguloObj.setAlto(a);

					} catch (Exception e) {
						a = -1;
						t.next();
						int auxiliar = 1;

					}
				} while ((a < 0));
				
				do {
					try {
						System.out.print("Introducir Ancho: ");
						b = t.nextInt();
						rectanguloObj = rectanguloObj.setAncho(b);

					} catch (Exception e) {
						b = -1;
						t.next();
						int auxiliar = 1;

					}
				} while ((b < 0)); //while ((b < 0)||(auxiliar!=1);

				break;
			
			//COPIA DE CREAR RECTANGULO (CIRCULO)
			case 2:
				do {
					try {
						System.out.println("Crear Circulo: ");
						System.out.print("Introducir Radio: ");
						a = t.nextInt();

						circuloObj = circuloObj.setRadio(a);

					} catch (Exception e) {
						a = -1;
						t.next();

					}
				} while ((a < 0));

				break;
			
			//COPIA DE CREAR RECTANGULO (TRIANGULO)
			case 3:
				do {
					try {
						System.out.println("Crear Triangulo: ");
						System.out.print("Introducir Altura :");
						a = t.nextInt();
						trianguloObj = trianguloObj.setAlto(a);
					} catch (Exception e) {
						a = -1;
						t.next();

					}
				} while ((a < 0));

				do {
					try {
						System.out.print("Introducir Base: ");
						b = t.nextInt();
						trianguloObj = trianguloObj.setAncho(b);
					} catch (Exception e) {
						b = -1;
						t.next();

					}
				} while ((b < 0));

				do {
					try {
						System.out.print("Introducir Angulo:");
						c = t.nextInt();

						trianguloObj = trianguloObj.setAngulo(c);
					} catch (Exception e) {
						c = -1;
						t.next();

					}

				} while ((a > 89));

				break;

			//SE LLAMA AL METODO GET-PERIMETRO DE CADA UNO DE LOS OBJETOS
			case 4:
				auxiliarAr = area;
				auxiliarAr = rectanguloObj.getPerimetro();
				System.out.println("Perimetro rectangulo: " + auxiliarAr);
				acirculo = circuloObj.getPerimetro();
				System.out.println("Perimetro del circulo: " + acirculo);
				acirculo = trianguloObj.getPerimetro();
				System.out.println("Perimetro triangulo: " + acirculo);

				break;
				
			//SE LLAMA AL METODO GET-AREA DE CADA OBJETO
			case 5:
				auxiliarAr = area;
				auxiliarAr = rectanguloObj.getArea();
				System.out.println("Area del rectangulo: " + auxiliarAr);
				acirculo = circuloObj.getArea();
				System.out.println("Area del circulo: " + acirculo);
				auxiliarAr = trianguloObj.getArea();
				System.out.println("Area del triangulo: " + auxiliarAr);
				break;

			}

		} while (opc != 0);
		t.close();
	}

}