package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import beans.Venta;

public class GestionLiberia {
	public void registrarVenta(Venta v) {
		//Conexi�n a la BBDD
		try(Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "")){ 
			java.sql.Date fdatos=new java.sql.Date(v.getFecha().getTime());
			String sql="insert into ventas(idCliente,idLibro,fecha) values(?,?,?)";
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setInt(1, v.getIdCliente());
			ps.setInt(2, v.getIdLibro());
			ps.setDate(3, fdatos);
			ps.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Venta> recuperarVentas(){
		//La firma del metodo es un Interfaz
		//Yo lo implemento con ArrayList, si mañana quiero otra implementacion, no cambio la cabecera del motodo (firma)
		//ayuda al desacoplamiento.
		ArrayList<Venta> lcon = new ArrayList<>();
		//Conexion a la BBDD
		try(Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "")){
			String sql="select * from ventas";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);			
			//if (!rs.next()) return null;
			while (rs.next()){
				/*
				//Conversion java.sql.Date en jav.util.Date
				java.sql.Date fsql = new java.sql.Date(100000000);
				//java.sql.Date es subclase de java.util.Date por lo que una contiene a la otra y puedo hacer...
				java.util.Date futil=fsql;
				DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale("es","ES"));
				System.out.println(df.format(rs.getDate("fecha")));*/
				//PREGUNTAR PORQUE NO SE TRAE LA HORA DE LA BBDD
				Venta venta = new Venta(rs.getInt("idVEnta"),rs.getInt("idCliente"),rs.getInt("idLibro"),rs.getDate("fecha"));
				lcon.add(venta);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lcon;
	}
	public static void main(String[] args) {
		GestionLiberia gl = new GestionLiberia();
		System.out.println("Listado Ventas");
		List<Venta> listaventa = gl.recuperarVentas();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy",new Locale("es","ES"));
		listaventa.forEach(v->System.out.println("idVenta: " + v.getIdVenta() + " idCliente: " + v.getIdCliente() + " idLibro: " + v.getIdLibro() + " Fecha: "+ df.format(v.getFecha())));

	}

}
