package TrabajosConClases;

/*
 * Pedro Daniel Pérez Sánchez
 * 
 * Trabajos Con Clases
 * 
 * 20/11/2018
 *  
 *  */

public class circulo {

	//COPIA DE RECTANGULO (CIRCULO)
	
	// MIEMBRO ESTATICO
	static int numcirculo = 0;
	static double PI = 3.14159;

	// ATRIBUTOS
	private int radio;

	// CONSTRUCTOR POR DEFECTO
	circulo() {
		radio = 1;

		numcirculo++;

	}

	// CONSTRUCTOR CON VARIABLES
	circulo(int rad) {
		radio = rad;
		numcirculo++;

	}

	public int getRadio() {
		return this.radio;
	}

	public circulo setRadio(int rad) {

		this.radio = rad;
		return this;

	}

	public static int contador() {
		return numcirculo;
	}

	public void modificar(int rad) {
		this.radio = rad;

	}

	public double getArea() { // Pi*r*r
		double area;
		area = (this.radio * this.radio) * PI;
		return area;
	}

	public double getPerimetro() {
		double perimetro;
		perimetro = 2 * PI * this.radio;
		return perimetro;
	}
}
