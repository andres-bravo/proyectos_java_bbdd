package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Movimiento;



public class GestionCajero {
	String cadena="jdbc:mysql://localhost:3306/bancabd";
	String user="root";
	String pwd="root";
	public boolean comprobarCuenta(int numCuenta) {
		boolean res=false;
		//creamos la conexión contra la base de datos
				try (Connection cn=DriverManager.getConnection(cadena, user, pwd);){							
					//definimos la instrucción SQL y la enviamos a través del objeto Statement
					String sql="Select * from cuentas where numerocuenta="+numCuenta;
					Statement st=cn.createStatement();
					ResultSet rs=st.executeQuery(sql);
					
					if(rs.next()) {
						res=true;
					}
					
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
				return res;
	}
	public void ingresar(int numCuenta, double cantidad) {
		try (Connection cn=DriverManager.getConnection(cadena, user, pwd);){							
			//definimos la instrucción SQL y la enviamos a través del objeto Statement
			cn.setAutoCommit(false);//anulamos autocommit
			String sql="update cuentas set saldo=saldo+? where numerocuenta=?";
			PreparedStatement st=cn.prepareStatement(sql);
			st.setDouble(1, cantidad);
			st.setInt(2, numCuenta);
			st.execute();
			registrarMovimiento(cn,numCuenta,cantidad,"ingreso");	
			cn.commit();//confirmamos tx

		}
		catch(SQLException ex) {
			
			ex.printStackTrace();
		}
	}
	public void extraer(int numCuenta, double cantidad) {
		try (Connection cn=DriverManager.getConnection(cadena, user, pwd);){
			
			//definimos la instrucción SQL y la enviamos a través del objeto Statement
			String sql="update cuentas set saldo=saldo-? where numerocuenta=?";
			PreparedStatement st=cn.prepareStatement(sql);
			st.setDouble(1, cantidad);
			st.setInt(2, numCuenta);
			st.execute();
			registrarMovimiento(cn,numCuenta,cantidad,"extracción");
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void transferencia(int cuentaOrigen,int cuentaDestino, double cantidad) {
		
			extraer(cuentaOrigen,cantidad);
			ingresar(cuentaDestino,cantidad);
			
	}
	
	
	public List<Movimiento> obtenerMovimientos(int numCuenta){
		ArrayList<Movimiento> movs=new ArrayList<>();
		try (Connection cn=DriverManager.getConnection(cadena, user, pwd);){							
			//definimos la instrucción SQL y la enviamos a través del objeto Statement
			String sql="select * from movimientos where idcuenta=? order by fecha DESC limit 5";
			PreparedStatement st=cn.prepareStatement(sql);
			st.setInt(1, numCuenta);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				movs.add(new Movimiento(rs.getInt("idMovimiento"),rs.getDouble("cantidad"),
						rs.getString("operacion"),
						rs.getInt("idcuenta"),
						rs.getTimestamp("fecha")));
			}				
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return movs;
	}
	private void registrarMovimiento(Connection cn,int numCuenta, double cantidad, String tipo) throws SQLException{
			java.util.Date factual=new Date();
			String sql="insert into movimientos (cantidad,operacion,idcuenta,fecha) values(?,?,?,?)";
			PreparedStatement st=cn.prepareStatement(sql);
			st.setDouble(1, cantidad);
			st.setString(2, tipo);
			st.setInt(3, numCuenta);
			//utilizamos Timestamp en lugar de Date para que se grabe la fecha y la hora
			//pues con sql.Date solo se nos grabaría la fecha
			st.setTimestamp(4,new java.sql.Timestamp(factual.getTime()));
			
			st.execute();
			
		
	}
	
}
