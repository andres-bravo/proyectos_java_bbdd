package modelo;


import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Contacto;

public class GestionContactos {
	HashMap<String,Contacto> agenda;
	public GestionContactos() {
		agenda=new HashMap<>();
	}
	public boolean agregarContacto(Contacto contacto) {
		//se añade si la clave no está ocupada
		return agregarContacto(contacto.getEmail(),contacto.getNombre(),contacto.getTelefono());
	}
	
	public boolean agregarContacto(String email, String nombre, int telefono) {
		//se añade si la clave no está ocupada
		if(!agenda.containsKey(email)) {
			Contacto c = new Contacto(nombre,email,telefono);
			agenda.put(email, c);
			return true;
		}else {
			return false;
		}
	}	
	public Contacto buscarContacto(String email) {
		return agenda.get(email);
	}
	public boolean eliminarContacto(String email) {
		if(agenda.containsKey(email)) {
			agenda.remove(email);
			return true;
		}else {
			return false;
		}
	}
	public Contacto[] recuperarContactos() {
			
		Collection<Contacto> nombres=agenda.values();
		return nombres.toArray(new Contacto[0]);
	}
	
	public List<Contacto> recuperarPorEdadMaxima(int edad) {
		//Devuelve todos los contactos en forma de lista de los valores cuya edad
		//sea menor que la edad pasada por parametro
		
		//Saco Stream del HashMap
		Stream<Contacto> st = agenda.values().stream(); 
		return st.filter(c->c.getEdad()<edad).collect(Collectors.toList());
	}
	public double edadMedia() {
		//Edad media de los Contactos
		//Aquí Necesito un Stream de enteros IntStream que tiene el método average para sacar media
		//Método para convertir el HasHMap a un IntStream
		Stream<Contacto> st = agenda.values().stream(); 
		return st.mapToInt(c->c.getEdad()).average().getAsDouble();
	}
	public Contacto recuperarPorTelefono(int tel) {
		//devuelve primer contacto con telefono indicado
		//Saco Stream del HashMap
		Stream<Contacto> st = agenda.values().stream(); 
		//Filtro por tel y saco el primero pero si no lo hay devuelvo null
		return st.filter(c->c.getTelefono()==tel).findFirst().orElse(null);
	}
	
	public String[] nombresDominio(String d) {
		//Array con los nombres de los empleados cuya direccion de correo contenga ese dominio
		//Saco Stream del HashMap
		Stream<Contacto> st = agenda.values().stream(); 
		//String[] s=st.filter(c->c.getEmail().endsWith(d)).map(c->c.getNombre()).collect(Collectors.toList()).toArray();
		return st.filter(c->c.getEmail().endsWith(d)).map(c->c.getNombre()).toArray(t->new String[t]);
	}
	public Contacto contactoMayor() {
		//Devuelve el contacto de mayor edad
		//Saco Stream del HashMap
		
		Stream<Contacto> st = agenda.values().stream();
		
		return st.max((a,b)->a.getEdad()-b.getEdad()).get();
		//Comparator<Contacto> comparator = Comparator.comparing(Contacto::getEdad);
		//return st.max(a,b)->a.getEdad()-b.getEdad()).getEdad();
			
	}
	
	
	
}
