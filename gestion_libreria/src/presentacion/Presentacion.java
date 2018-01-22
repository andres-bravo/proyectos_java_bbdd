package presentacion;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import beans.Venta;
import modelo.GestionLiberia;



public class Presentacion {
	public static void main(String[] args) {	
		int op;
		int idCliente,idLibro;
		Date fecha;
		GestionLiberia gl = new GestionLiberia();
		Scanner sc=new Scanner(System.in);
		Venta venta = null;
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy",new Locale("es","ES"));
		do{
			System.out.println("1.- Añadir Venta");
			System.out.println("2.- Devolver Ventas");
			System.out.println("3.- Salir");
			op=Integer.parseInt(sc.nextLine());
			switch(op){
	    		case 1:	    			
	    			System.out.println("idCliente:");
		        idCliente=Integer.parseInt(sc.nextLine());
		        System.out.println("idLibro:");
		        idLibro=Integer.parseInt(sc.nextLine());
		        //Admite medium 20 ene. 2018 0:00:00
		        System.out.println("Fecha Venta (dd-mm-yyyy):");
		        try {
					fecha =  df.parse(sc.nextLine());
			        venta = new Venta(0,idCliente,idLibro,fecha);
			        gl.registrarVenta(venta);
				} catch (ParseException e) {
					System.out.println("Error en formato fecha");
					e.printStackTrace();
					break;
				}
		        break;
	    		case 2:
	    			System.out.println("Listado Ventas");
	    			List<Venta> listaventa = gl.recuperarVentas();
	    			listaventa.forEach(v->System.out.println("idVenta: " + v.getIdVenta() + " idCliente: " + v.getIdCliente() + " idLibro: " + v.getIdLibro() + " Fecha: "+ df.format(v.getFecha())));
	    		case 3:
	    			break;
	    		default:
	    			System.out.println("debes escribir una opciï¿½n vï¿½lida");
	        }
		}while(op!=3);
	}
}
