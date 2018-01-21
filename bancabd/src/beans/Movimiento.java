package beans;

import java.util.Date;

public class Movimiento {
	private int idCuenta;
	private String operacion;
	private double cantidad;
	private Date fecha;
	public Movimiento(int idCuenta, String operacion, double cantidad, Date fecha) {
		super();
		this.idCuenta = idCuenta;
		this.operacion = operacion;
		this.cantidad = cantidad;
		this.fecha = fecha;
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
