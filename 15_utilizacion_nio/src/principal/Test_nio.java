package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Test_nio {
	public static void main(String[] args) {	
		String fichero="d:\\temporal\\dias.txt";
		//Devuelve objeto Path apuntando al fichero
		Path pt=Paths.get(fichero);
		//Files.copy(pt, new FileOutputStream("d:\\temporal\\copia.txt"));
		ArrayList<String> masDias=new ArrayList<>();
		masDias.add("jueves");
		try {
			Files.write(pt, masDias, StandardOpenOption.APPEND);
		}
		catch(IOException e) {
				e.printStackTrace();
		}
	}
}
