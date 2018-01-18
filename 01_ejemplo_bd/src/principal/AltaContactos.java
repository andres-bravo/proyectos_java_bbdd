package principal;

import java.sql.Connection;
import java.sql.DriverManager;

public class AltaContactos {

	public static void main(String[] args) {
		
		//creamos conexion a la BBDD
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");
		String sql = "Insert into contactos(nombre,email,telefono) values('eclipse','eclipse@gmail.com',3333)";
		

	}

}
