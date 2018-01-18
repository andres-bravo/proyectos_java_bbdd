package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AltaContactos {

	public static void main(String[] args) {
		//creamos conexion a la BBDD
		Connection cn;
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");
			String sql = "Insert into contactos(nombre,email,telefono) values('eclipse','eclipse@gmail.com',3333)";
			//creamos objeto Statement y enviamos instruccion SQL
			Statement st=cn.createStatement();
			st.execute(sql);
			cn.close();
			System.out.println("Contacto añadido.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
