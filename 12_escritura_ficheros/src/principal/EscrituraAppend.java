package principal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class EscrituraAppend {

	public static void main(String[] args) {
		//Si no pongo ruta te lo crea en el directorio del proyecto que es el directorio por defecto.
		String fichero = "d:\\temporal\\dias.txt";
		//Para trabajar en modo append utilizo FileOutputStream
		try(FileOutputStream fs = new FileOutputStream(fichero,true)){
			//Al PrintStream le paso el FileOutputStream tiene constructor que acepta FileOutputStream
			PrintStream	salida= new PrintStream(fs);
			salida.println("lunes");
			salida.println("martes");
			salida.println("miercoles");
		}
		catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
