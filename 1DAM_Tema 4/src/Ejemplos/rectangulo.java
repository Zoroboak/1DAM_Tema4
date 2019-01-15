package Ejemplos;

public class rectangulo {
	
	private static int numrect = 0;
	
	// ATRIBUTOS
	private int alto;
	private int ancho;

	// CONSTRUCTOR
	rectangulo() {
		alto = 1;
		ancho = 1;
		numrect++;
	}

	// CONSTRUCTOR
	rectangulo(int al, int an) {
		alto = al;
		ancho = an;
		numrect++;

	}

	// METODO PARA DEVOLVER PROPIEDADES
	public int getAlto() {
		return this.alto;
	}

	// METODO PARA DEVOLVER PROPIEDADES
	public int getAncho() {
		return this.ancho;
	}

	public rectangulo setAlto(int al) {
		this.alto = al;
		return this;
	}

	public void setAncho(int an) {
		this.ancho = an;
	}
	
	public static void eliminar() {
		numrect--;
		
	}
	public static int contar() {
		return numrect;
		
	}

}