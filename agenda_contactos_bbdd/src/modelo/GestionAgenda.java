package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionAgenda {
	public void alta(String nombre, String email, int telefono) {
		String query = "Insert into contactos(nombre,email,telefono) values('"+nombre+"','"+email+"',"+telefono+")";
		this.query(query);
	}
	public void eliminar(String email) {
		String query = "Delete from contactos where email='"+email+"'";
		this.query(query);
	}
	private void query(String query) {
		//creamos conexion a la BBDD
		Connection cn=null;
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");
			String sql = query;
			//creamos objeto Statement y enviamos instruccion SQL
			Statement st=cn.createStatement();
			st.execute(sql);
			cn.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//cierre conexión
			try {
				if(cn!=null) {
					cn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
