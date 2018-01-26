package presentacion;

import java.util.List;
import java.util.Scanner;

import beans.Contacto;
import modelo.GestionAgenda;

public class Presentacion {
	public static void main(String[] args) {	
		int op;
		String nombre,email;
		int telefono;
		GestionAgenda ga= new GestionAgenda();
		Scanner sc=new Scanner(System.in);
		Contacto con = null;
		do{
			System.out.println("1.- Agregar Contacto");
			System.out.println("2.- Borrar Contacto");
			System.out.println("3.- Buscar Contacto");
			System.out.println("4.- Listar Contactos");
			System.out.println("5.- Salir");
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
	    			System.out.println("email:");
		            email=sc.nextLine();
		            con = ga.buscar(email);
		            if (con!=null) {
		            	System.out.println("Nombre: " + con.getNombre());
		            	System.out.println("Email: " + con.getEmail());
		            	System.out.println("Telefono: " + con.getTelefono());
		            }
		            else
		            	System.out.println("No hay datos del contacto");
	    			break;
	    		case 4:
	    			System.out.println("Listado Contactos");
	    			List<Contacto> listacon = ga.recuperarTodos();
	    			listacon.forEach(c->System.out.println("Nombre: " + c.getNombre() + " Email: " + c.getEmail() + " Telefono: " + c.getTelefono()));
	    			break;
	    		case 5:
	    			break;
	    		default:
	    			System.out.println("debes escribir una opción válida");
	        }
		}while(op!=5);
	}
}
