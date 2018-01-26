package modelo;

public class Singleton {
	//Una variable de clase (static) para controlar que sólo haya un objeto de esta clase
	//lo hago en el constructor preguntando por esta variable para ver que no hay otra instanciada.
	private static Singleton obj;
	//Al disponer de un constructor privado nadie puede desde fuera crear una 
	//clase de ella.
	private Singleton() {
		
	}
	public static Singleton getSingleton() {
		if(obj==null) {
			obj=new Singleton();
		}
		return obj;
	}
}
