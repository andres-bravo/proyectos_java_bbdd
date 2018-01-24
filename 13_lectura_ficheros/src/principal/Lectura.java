package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lectura {

	public static void main(String[] args) {
		String fichero = "d:\\temporal\\dias.txt";
		try(FileReader fr = new FileReader(fichero);
					BufferedReader bf = new BufferedReader(fr)) {
			//Manera Clásica
			/*String s;			
			while ((s=bf.readLine())!=null){
				System.out.println(s);	
			}*/
			//Con Streams
			bf.lines().forEach(s->System.out.println(s));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
