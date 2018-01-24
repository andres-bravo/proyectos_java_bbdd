package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Cuenta;
import beans.Movimiento;

public class GestionBancaBd {
	private Cuenta cuenta;
	private ArrayList<Movimiento> movimientos;
	/*
	String cadena="jdbc:mysql://localhost:3306/bancabd";
	String user="root";
	String pwd="root";*/
	private String cadena,user,pwd;
	public GestionBancaBd() {
		String fichero = "/Users/abravo/git/proyectos_java_bbdd/bancabd/src/config/conexion.txt";
		try(FileReader fr = new FileReader(fichero);
				BufferedReader bf = new BufferedReader(fr)) {
			//Manera Cl�sica
			String s;
			System.out.println("Entro en constructor.");
			while ((s=bf.readLine())!=null){
				//System.out.println(s);
				if (s.contains("user")) {
					user = s.substring(s.indexOf("|")+1);
				}
				else if (s.contains("pwd")){
					pwd = s.substring(s.indexOf("|")+1);
				}
				else if (s.contains("conexion")) {
					cadena = s.substring(s.indexOf("|")+1);;
				}
			}
				//Con Streams
				//bf.lines().forEach(s->System.out.println(s));
		}	
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	private void grabarCuenta(Cuenta c) {
		//graba Cuenta en BBDD
		//Conexi�n a la BBDD
		try(Connection cn= DriverManager.getConnection(cadena,user,pwd)){ 
			String sql="update cuentas set (numeroCuenta,saldo,tipocuenta) where  values(?,?,?)";
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setInt(1, c.getNumeroCuenta());
			ps.setDouble(2, c.getSaldo());
			ps.setString(3, c.getTipocuenta());
			ps.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	private void grabarMovimiento(Movimiento m){
		//Graba Movimiento
		//Conexi�n a la BBDD
		try(Connection cn= DriverManager.getConnection(cadena,user,pwd)){
			java.sql.Date fdatos=new java.sql.Date(m.getFecha().getTime());
			java.util.Date factual = new Date();
			String sql="insert into movimientos(idCuenta,cantidad,fecha,operacion) values(?,?,?,?)";
			PreparedStatement ps= cn.prepareStatement(sql);
			ps.setInt(1, m.getIdCuenta());
			ps.setDouble(2, m.getCantidad());
			ps.setTimestamp(3, new java.sql.Timestamp(m.getFecha().getTime()));
			ps.setString(4, m.getOperacion());
			ps.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	public Cuenta recuperarCuenta(int numCuenta){
		Cuenta c = null;
		//Conexion a la BBDD
		try(Connection cn= DriverManager.getConnection(cadena,user,pwd)){
			String sql="select * from cuentas where numeroCuenta="+numCuenta;
			System.out.println("SQL"+sql);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			System.out.println(rs.getInt("numeroCuenta")+"Traza:"+rs.getDouble("saldo")+rs.getString("tipocuenta"));
			//if (rs != null){
				/*
				//Conversion java.sql.Date en jav.util.Date
				java.sql.Date fsql = new java.sql.Date(100000000);
				//java.sql.Date es subclase de java.util.Date por lo que una contiene a la otra y puedo hacer...
				java.util.Date futil=fsql;
				DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale("es","ES"));
				System.out.println(df.format(rs.getDate("fecha")));*/
				//PREGUNTAR PORQUE NO SE TRAE LA HORA DE LA BBDD
				c = new Cuenta(rs.getInt("numeroCuenta"),rs.getDouble("saldo"),rs.getString("tipoCuenta"));				
			//}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;		
	}
	public void ingresar(int numCuenta, double cantidad) {
		//Ingresar en cuenta y añadir movimiento
		//Conexi�n a la BBDD
		Cuenta c;
		Movimiento m;
		c=this.recuperarCuenta(numCuenta);
		if (c!=null){
			c.ingresar(cantidad);
			this.grabarCuenta(c);
			m = new Movimiento(c.getNumeroCuenta(), "ingreso", cantidad, new Date());
			this.grabarMovimiento(m);
		}
	}
	public void extraer(int numCuenta, double cantidad) {
		//Ingresar en cuenta y añadir movimiento
		//Conexi�n a la BBDD
		Cuenta c;
		Movimiento m;
		c=this.recuperarCuenta(numCuenta);
		if (c!=null){
			c.extraer(cantidad);
			this.grabarCuenta(c);
			m = new Movimiento(c.getNumeroCuenta(), "extracción", cantidad, new Date());
			this.grabarMovimiento(m);
		}
	}
	public List<Movimiento> ultimosMovimientos(int numCuenta){
		//La firma del metodo es un Interfaz
		//Yo lo implemento con ArrayList, si mañana quiero otra implementacion, no cambio la cabecera del motodo (firma)
		//ayuda al desacoplamiento.
		ArrayList<Movimiento> lmov = new ArrayList<>();
		//Conexion a la BBDD
		try(Connection cn= DriverManager.getConnection(cadena,user,pwd)){
			String sql="select * from movimientos where idCuenta="+numCuenta+" order by idMovimiento DESC limit 5";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);			
			while (rs.next()){
				/*
				//Conversion java.sql.Date en jav.util.Date
				java.sql.Date fsql = new java.sql.Date(100000000);
				//java.sql.Date es subclase de java.util.Date por lo que una contiene a la otra y puedo hacer...
				java.util.Date futil=fsql;
				DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale("es","ES"));
				System.out.println(df.format(rs.getDate("fecha")));*/
				//PREGUNTAR PORQUE NO SE TRAE LA HORA DE LA BBDD
				Movimiento m = new Movimiento(rs.getInt("idCuenta"), rs.getString("operacion"), 
											rs.getDouble("cantidad"), rs.getDate("fecha"));
				lmov.add(m);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lmov;		
	}

	public static void main(String[] args) {
		System.out.println("Llamo a constructor");
		GestionBancaBd gbd = new GestionBancaBd();
		System.out.println(gbd.cadena+" "+gbd.user+" "+ gbd.pwd);
	}

}
