package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Contacto;



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
			//cierre conexi�n
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
	private void queryPrepStatement(String nombre, String email, int tel) {
		//Query con PreparedStatement y try con recursos
		try(Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root")){
			String sql="insert into contactos(nombre,email,telefono) values(?,?,?)";
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, email);
			ps.setInt(3, tel);
			ps.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Contacto buscar(String email) {
		Contacto c=null;
		//Conexi�n a la BBDD
		try(Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root")){
			String sql="select * from contactos where email='" +email+"'";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				c = new Contacto(rs.getString("nombre"),rs.getString("email"),rs.getInt("telefono"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	public List<Contacto> recuperarTodos(){
		//La firma del m�todo es un Interfaz
		//Yo lo implemento con ArrayList, si ma�ana quiero otra implementaci�n, no cambio la cabecera del m�todo (firma)
		//ayuda al desacoplamiento.
		ArrayList<Contacto> lcon = new ArrayList<>();
		//Conexi�n a la BBDD
		try(Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root")){
			String sql="select * from contactos";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);			
			if (!rs.next()) return null;
			while (rs.next()){
				Contacto con = new Contacto(rs.getString("nombre"),rs.getString("email"),rs.getInt("telefono"));
				lcon.add(con);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lcon;
	}
}
