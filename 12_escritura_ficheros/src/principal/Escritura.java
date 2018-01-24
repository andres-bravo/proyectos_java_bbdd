package principal;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Escritura {

	public static void main(String[] args) {
		//Si no pongo ruta te lo crea en el directorio del proyecto que es el directorio por defecto.
		String fichero = "dias.txt";
		try(PrintStream	salida= new PrintStream(fichero)){
			salida.println("lunes");
			salida.println("martes");
			salida.println("martes");
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}
