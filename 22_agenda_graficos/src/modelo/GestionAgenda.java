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
	public void alta(String nombre, String email, int tel) {
		
		//creamos conexión contra la base de datos
		try(Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");) {	
			/*String sql="Insert into contactos(nombre,email,telefono) values('"+nombre+"','"+email+"',"+tel+")";
			//creamos objeto Statement y enviamos instrucción SQL
			Statement st=cn.createStatement();
			st.execute(sql);*/
			//consulta preparada
			String sql="insert into contactos(nombre,email,telefono) values(?,?,?)";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, email);
			ps.setInt(3, tel);
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	public int eliminar(String email) {
		int res=0;
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");){
			
			String sql="Delete from contactos where email='"+email+"'";
			//creamos objeto Statement y enviamos instrucción SQL
			Statement st=cn.createStatement();
			res=st.executeUpdate(sql);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}

	public Contacto buscar(String email) {
		Contacto c=null;
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");){
			String sql="select * from contactos where email='"+email+"'";
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				c=new Contacto(rs.getString("nombre"),rs.getString("email"),rs.getInt("telefono"));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return c;
	}
	
	public List<Contacto> recuperarTodos() {
		ArrayList<Contacto> contactos=new ArrayList<>();
		try (Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");){
			String sql="select * from contactos";
			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			/*Statement st2=cn.createStatement();
			st2.execute("insert into contactos(nombre,email,telefono) values('c1','e1',11)");
			*/
			while(rs.next()) {
				Contacto c=new Contacto(rs.getString("nombre"),rs.getString("email"),rs.getInt("telefono"));
				contactos.add(c);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return contactos;
	}

}
