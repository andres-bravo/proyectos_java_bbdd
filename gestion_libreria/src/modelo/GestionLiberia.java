package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Venta;

public class GestionLiberia {
	public void registrarVenta(Venta v) {
		//Conexión a la BBDD
		try(Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "root")){ 
			java.sql.Date fdatos=new java.sql.Date(v.getFecha().getTime());
			String sql="insert into ventas(idCliente,idLibro,fecha) values(?,?,?)";
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setInt(1, v.getIdCliente());
			ps.setInt(2, v.getIdLibro());
			ps.setDate(3, fdatos);
			ps.execute();
			ResultSet rs = ps.executeQuery(sql);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Venta> recuperarVentas(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
