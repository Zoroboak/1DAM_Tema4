package Trabajos;

/*
 * PEDRO DANIEL PÉREZ SÁNCHEZ
 * 
 * TRABAJO CON VECTORES
 * 
 * 02/12/2018
 *  
 ****/

public class TrabajoConVectores {
	
	final static int[] Sumas = {2,3,4,5,6,7,8,9,10,11,12};
	final static int[] Veces = {3,8,9,11,20,19,16,13,11,6,4};
	
	//METODO PARA DEVOLVER LA MEDIA
	public static double media() {
		
		//VARIABLE LOCAL
		double mediaSuma = 0;
		
		//HACER SUMATORIO DE VECTORES
		for (int i = 0; i < Veces.length; i++) {
			mediaSuma += Sumas[i] * Veces[i];
		 }	
		//HAYAR LA MEDIA
		double media = mediaSuma/120;
		
		//DEVOLVER EL RESULTADO DEL METODO
		return media;
	}
	
	//METODO PARA DEVOLVER LA DESVIACIÓN TIPICA
	public static double desviacionTipica(double aux1) {
		
		//VARIABLE LOCAL
		double mediaSuma = 0;
	
		//HACER SUMATORIO DE VECTORES
		for (int i = 0; i < Veces.length; i++) {
			mediaSuma += (Sumas[i]*Sumas[i]) * Veces[i];
		 }	
		//HAYAR LA MEDIA
		double media = mediaSuma/120;
		
		//HACER LA RAIZ CUADRADA SEGÚN LA FORMULA
		double desviacion = Math.sqrt(media - (aux1*aux1));
		
		//DEVOLVER RESULTADO DEL METODO DESVIACION
		return desviacion;
	}
	
	//HAYAR PORCENTAJE DE VALORES COMPRENDIDOS (x − σ, x + σ).
	//(LA O ES LA DESVIACIÓN TIPICA)
	public static double porcentaje(double media, double desv) {
		
		//VARIABLES LOCALES
		double sumasXmenoso = 0;
		double sumasXmaso = 0;
		double SumasLocal = 0;
		double totalSuma = 0;
		double porcentaje = 0;
		
		//IDENTIFICAR PRIMER VALOR QUE QUEREMOS LOCALIZAR
		sumasXmenoso = media-desv;

		//IDENTIFICAR SEGUNDO VALOR QUE QUEREMOS LOCALIZAR
		sumasXmaso = media+desv;
		
		//COMPROBAR UNA POR UNA LAS VARIABLES DEL VECTOR
		for (int i = 0; i < Sumas.length; i++) {
			
			//10-2 = 8
			//10+2 = 12
					
			//SUMO SI SE CUMPLE LA CONDICIÓN DESEADA
			if ((Sumas[i]>sumasXmenoso)&&(Sumas[i]<sumasXmaso)) {
				SumasLocal += (Sumas[i] * Veces[i]);
			}
			
			//CALCULO EL TOTAL PARA EL PORCENTAJE
			totalSuma += Sumas[i] * Veces[i];
			
		}
		
		//CALCULAR PORCENTAJE
		porcentaje = (SumasLocal/totalSuma)*100;
		
		//PASAR EL RESULTADO A UN INTEGRER POR QUE ME DA ERROR AL REDONDEARLO 
		int x = (int) porcentaje;
		
		//System.out.println(totalSuma); //VER EL TOTAL SUMA
		
		//DEVOLVER RESULTADO EN PORCENTAJE
		return x;
	}
	
	public static void main(String[] args) {
		double aux = media();
		double desviacionTipica = desviacionTipica(aux);
		System.out.println("La media entre los vectores es: "+aux);
		System.out.println("La desviación tipica (σ) es: "+desviacionTipica);
		System.out.println("Porcentaje de valores comprendidos en el intervalo (x − σ, x + σ): "+porcentaje(aux, desviacionTipica)+"%");
		
		
	}
}
