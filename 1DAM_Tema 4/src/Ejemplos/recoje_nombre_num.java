package Ejemplos;

public class recoje_nombre_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=0,b=0;
		
		try {
			
			
			if(args.length >=3) {
				System.out.println("Hola "+args[0]);
				a=Integer.parseInt(args[1]);
				b=Integer.parseInt(args[2]);
			}else if(args.length == 2) {
				System.out.println("Hola "+args[0]);
				a=Integer.parseInt(args[1]);
			}else {
				System.out.println("Hola "+args[0]);
			}
			
		}
		catch(Exception e){
			System.out.println("Hola Invitado");
		}
		
		
		int c = a + b;
		System.out.println("La suma de  "+a+" y "+b+" es igual a "+c);
		
	}

}
