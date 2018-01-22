package beans;

import java.util.Date;

public class Movimiento {
	//idMovimiento es autogenerado por la BBDD es conveniente tenerlo
	//un bean encapsula todos los campos aunque sea generado por la BBDD
	//puedo tener / debo tener dos constructores
	private int idMovimiento; 
	private int idCuenta;
	private String operacion;
	private double cantidad;
	private Date fecha;
	//Constructor sin el idMovimiento
	public Movimiento(int idCuenta, String operacion, double cantidad, Date fecha) {
		super();
		this.idCuenta = idCuenta;
		this.operacion = operacion;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	//Constructor con todos los campos de la BBDD
	public Movimiento(int idMovimiento,int idCuenta, String operacion, double cantidad, Date fecha) {
		super();
		this.idMovimiento = idMovimiento;
		this.idCuenta = idCuenta;
		this.operacion = operacion;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
