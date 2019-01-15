package TrabajosConClases;

/*
 * Pedro Daniel Pérez Sánchez
 * 
 * Trabajos Con Clases
 * 
 * 20/11/2018
 *  
 *  */

public class triangulo {

	// MIEMBRO ESTATICO
	static int numtriangulo = 0;

	// ATRIBUTOS
	private int alto;
	private int ancho;
	private int angulo;

	// CONSTRUCTOR POR DEFECTO
	triangulo() {
		alto = 1;
		ancho = 1;
		angulo = 90;
		numtriangulo++;

	}

	// CONSTRUCTOR CON VARIABLES
	triangulo(int al, int an, int angul) {
		alto = al;
		ancho = an;// base
		angulo = angul;
		numtriangulo++;

	}

	public int getAlto() {
		return this.alto;
	}

	public int getAncho() {
		return this.ancho;
	}

	public triangulo setAlto(int al) {

		this.alto = al;
		return this;
	}

	public triangulo setAncho(int an) {

		this.ancho = an;
		return this;

	}

	public triangulo setAngulo(int angul) {
		this.angulo = angul;

		return this;
	}

	public static int contador() {
		return numtriangulo;
	}

	public void modificar(int a, int b, int angul) {
		this.alto = a;
		this.ancho = b;
		this.angulo = angul;

	}

	public float getArea() {
		float area;
		area = (this.alto * this.ancho) / 2;
		return area;
	}

	public double getPerimetro() {
		double a, b, ba, bc, x, y, perimetro;
		double angulorad = Math.toRadians(this.angulo);

		a = this.alto / Math.sin(angulorad);
		ba = 180 - (this.angulo + 90);
		bc = this.angulo;
		x = (a * a) / this.ancho;
		y = this.ancho - x;
		double bcr = Math.toRadians(bc);
		b = y / Math.sin(bcr);
		perimetro = a + b + this.ancho;

		return perimetro;
	}

}
