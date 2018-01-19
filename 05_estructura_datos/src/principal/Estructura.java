package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Estructura {

	public static void main(String[] args) {
		//Conexión a la BBDD
		try(Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root")){
			String sql="select * from contactos";
			Statement st = cn.createStatement();
			//Sacamos la estructura de la tabla.
			//Nombre y Tipo de cada columna.
			ResultSet rs=st.executeQuery(sql);
			ResultSetMetaData rsmt = rs.getMetaData();
			for (int i=1; i<=rsmt.getColumnCount();i++) {
				System.out.println(rsmt.getColumnName(i)+"-"+rsmt.getColumnTypeName(i));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
