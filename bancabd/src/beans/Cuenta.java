package beans;

public class Cuenta {
	private int numeroCuenta;
	private double saldo;
	private String tipocuenta;

	public Cuenta(int numeroCuenta, double saldo, String tipocuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipocuenta = tipocuenta;
	}
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipocuenta() {
		return tipocuenta;
	}
	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}
	public void ingresar(double cant) {
		this.saldo+=cant;
	}
	public void extraer(double cant) {
		saldo-=cant;
	}
	public double getSaldo(){
		return saldo;
	}
}
