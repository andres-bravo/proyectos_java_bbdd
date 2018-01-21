package presentacion;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import beans.Movimiento;
import modelo.GestionBancaBd;


/*
 * Al inicial el programa, se solicita al usuario el saldo inicial y el 
 * l�mite de la cuenta (m�xima cantidad a extraer en un proceso)
 * Con herencia a partir de Cuenta hacer todo esto.
 * Una vez solicitado l�mite de la cuenta motrar el menu:
 * 1. Ingresar
 * 2. Extraer
 * 3. Movimientos y saldo
 * 4. Salir
 * 
 * 1. Se solicita la cantidad a ingresar y se procede al ingreso
 * 2. Se solicita la cantidad a extraer, si es inferior o igual al l�mite
 * se realiza la extraccion. si no no se hace
 * 3. Muestra los movimientos realizados en la cuenta y el saldo final.
 * Cada movimiento se caracteriza por un tipo (ingreso o extraccion) y una cantidad.
 */
public class Cajero {

	public static void main(String[] args) {
		int op,numCuenta;
		double cantidad;
		boolean resultado;
		GestionBancaBd gbancabd = new GestionBancaBd();
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca Numero de Cuenta");
		numCuenta = Integer.parseInt(sc.nextLine());
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy",new Locale("es","ES"));
		do{
			System.out.println("---------------MENU DE OPCIONES-----------------");
			System.out.println("1.- Ingresar");
		    System.out.println("2.- Extraer");
		    System.out.println("3.-Transferencia");
		    System.out.println("4.- Movimientos y Saldo");
		    System.out.println("5.- Salir");
		    System.out.println("------------------------------------------------");
		    op=Integer.parseInt(sc.nextLine());
		    switch(op){
		    	case 1:
		    		System.out.println("Cantidad a Ingresar:");
		        cantidad=Double.parseDouble(sc.nextLine());
		        gbancabd.ingresar(numCuenta, cantidad);
		        break;
		    case 2:
		    		/*
	    			System.out.println("Cantidad a Extraer:");
		        cantidad=Double.parseDouble(sc.nextLine());
		        if (cantidad<=cuenta.getLimite()) {
		        		cuenta.extraer(cantidad);
		        		System.out.println("Saldo:"+cuenta.getSaldo()+ " Limite: "+ cuenta.getLimite());
		        }
		        else
		        		System.out.println("Ha superado el limite.");
		        	*/
		        break;
		    case 3:
		    		/*
		    		mov = cuenta.listaMovimientos();
		    		System.out.println("---------------LISTADO DE MOVIMIENTOS----------");
		    		mov.forEach(n->System.out.println("Tipo: "+ n.getTipo()+" Cantidad: "+n.getCantidad()));
		    		System.out.println("---------------SALDO---------------------------");
		    		System.out.println("Saldo: "+ cuenta.getSaldo());
		    		*/
		        break;
		    case 4:
	    			/*
	    			mov = cuenta.listaMovimientos();
	    			System.out.println("---------------LISTADO DE MOVIMIENTOS----------");
	    			mov.forEach(n->System.out.println("Tipo: "+ n.getTipo()+" Cantidad: "+n.getCantidad()));
	    			System.out.println("---------------SALDO---------------------------");
	    			System.out.println("Saldo: "+ cuenta.getSaldo());
	    			 */
		    		List<Movimiento> listaMov = gbancabd.ultimosMovimientos(numCuenta);
		    		listaMov.forEach(m->System.out.println("Fecha: "+ df.format(m.getFecha())+ " "+m.getOperacion()+" Cantidad: "+ m.getCantidad()));
		    		break;
		    case 5:
		        	break;
		    default:
		        System.out.println("debes escribir una opcion valida");
		    }
		    }while(op!=5);
	}

}
