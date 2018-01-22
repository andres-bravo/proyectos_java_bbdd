package presentacion;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import beans.Movimiento;
import modelo.GestionCajero;

public class Principal {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        double cantidad,saldo;
        int op;//opcion elegida
		int cuenta;
		GestionCajero gcajero=new GestionCajero();
		System.out.println("Número de cuenta:");
		cuenta=Integer.parseInt(sc.nextLine());
		if(!gcajero.comprobarCuenta(cuenta)) {
			System.out.println("Cuenta no existe");
			return;
		}
		
		        
		        do{
		           System.out.println("1.- Extraer");
		           System.out.println("2.- Ingresar");
		           System.out.println("3.- Transferencia");
		           System.out.println("4.- Movimientos");
		           System.out.println("5.- Salir");
		           op=Integer.parseInt(sc.nextLine());
		           switch(op){
		               case 1:
		                   System.out.println("Cantidad:");
		                   cantidad=Double.parseDouble(sc.nextLine());
		                   gcajero.extraer(cuenta, cantidad);
		                   break;
		               case 2:
		            	   System.out.println("Cantidad:");
		                   cantidad=Double.parseDouble(sc.nextLine());
		                   gcajero.ingresar(cuenta, cantidad);
		                   break;
		                  
		               case 3:
		            	   System.out.println("Cuenta destino: "); 
		            	   int destino=Integer.parseInt(sc.nextLine());
		            	   System.out.println("Cantidad:");
		                   cantidad=Double.parseDouble(sc.nextLine());
		                   gcajero.transferencia(cuenta, destino, cantidad);
		                   break;
		               case 4:
		            	   List<Movimiento> movimientos=gcajero.obtenerMovimientos(cuenta);
		            	   movimientos.forEach(m->{
		            		   						DateFormat df=DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale("es","ES"));
		            		   						System.out.println(m.getOperacion()+"-"+
		            			   									 m.getCantidad()+"-"+
		            			   									 df.format(m.getFecha()));
		            	   
		            	   });
		            	   break;
		               case 5:
		                   break;
		               default:
		                   System.out.println("debes escribir una opción válida");
		           }
		        }while(op!=5);
	}

}
