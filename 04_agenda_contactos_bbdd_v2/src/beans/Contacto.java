package beans;

public class Contacto {
	private String nombre;
	private String email;
	private int telefono;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Contacto(String nombre, String email, int telefono) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}
}
