package presentacion;

import java.util.Scanner;

import modelo.GestionAgenda;

public class Presentacion {
	public static void main(String[] args) {	
		int op;
		String nombre,email;
		int telefono;
		GestionAgenda ga= new GestionAgenda();
		Scanner sc=new Scanner(System.in);

		do{
			System.out.println("1.- Agregar Contacto");
			System.out.println("2.- Borrar Contacto");
			System.out.println("3.- Salir");
			op=Integer.parseInt(sc.nextLine());
			switch(op){
	    		case 1:
	    			System.out.println("Nombre:");
		            nombre=sc.nextLine();
		            System.out.println("Email:");
		            email=sc.nextLine();
		            System.out.println("Telefono");
		            telefono=Integer.parseInt(sc.nextLine());
		            ga.alta(nombre, email, telefono);
		            break;
	    		case 2:
	    			System.out.println("email:");
		            email=sc.nextLine();
		            ga.eliminar(email);
	    		case 3:
	    			break;
	    		default:
	    			System.out.println("debes escribir una opción válida");
	        }
		}while(op!=3);
	}
}
