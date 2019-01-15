package TrabajosConClases;

/*
 * Pedro Daniel Pérez Sánchez
 * 
 * Trabajos Con Clases
 * 
 * 20/11/2018
 *  
 *  */

public class rectangulo {
	
	
	//COPIA DE RECTANGULO (TRIANGULO)

	// MIEMBRO ESTATICO
	static int numrectangulo = 0;

	// ATRIBUTOS
	private int alto;
	private int ancho;

	// CONSTRUCTOR POR DEFECTO
	rectangulo() {
		alto = 1;
		ancho = 1;
		numrectangulo++;

	}

	// CONSTRUCTOR CON VARIABLES
	rectangulo(int al, int an) {
		alto = al;
		ancho = an;
		numrectangulo++;

	}

	public int getAlto() {
		return this.alto;
	}

	public int getAncho() {
		return this.ancho;
	}

	public rectangulo setAlto(int al) {

		this.alto = al;
		return this;
	}

	public rectangulo setAncho(int an) {

		this.ancho = an;
		return this;

	}

	public int contador() {
		return numrectangulo;
	}

	public void modificar(int a, int b) {
		this.alto = a;
		this.ancho = b;

	}

	public float getArea() {
		float area;
		area = this.alto * this.ancho;
		return area;
	}

	public float getPerimetro() {
		float perimetro;
		perimetro = 2 * (this.alto) + 2 * (this.ancho);

		return perimetro;
	}
}
