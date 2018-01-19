package beans;

import java.util.Date;

public class Venta {
	int idVenta;
	int idCliente;
	int idLibro;
	Date fecha;
	public Venta(int idVenta, int idCliente, int idLibro, Date fecha) {
		super();
		this.idVenta = idVenta;
		this.idCliente = idCliente;
		this.idLibro = idLibro;
		this.fecha = fecha;
	}
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
