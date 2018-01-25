package temperatura_ciudades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import beans.Ciudad;

public class GestionCiudades {
	String ficherociudades;
	public GestionCiudades(String nombrefichero){
		this.ficherociudades=nombrefichero;
	}
	public void guardarciudad(String nombre, double temp) {
		//Para trabajar en modo append utilizo FileOutputStream
		try(FileOutputStream fs = new FileOutputStream(ficherociudades,true)){
			//Al PrintStream le paso el FileOutputStream tiene constructor que acepta FileOutputStream
			PrintStream	salida= new PrintStream(fs);
			salida.println(nombre+"|"+temp);
		}
		catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public double temperaturaMedia() {
		double db=0.0;
		try(FileReader fr = new FileReader(this.ficherociudades);
				BufferedReader bf = new BufferedReader(fr)) {
				db=bf.lines()
						.mapToDouble(s->Double.parseDouble(s.split("[|]")[1]))
						.average()
						.getAsDouble();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return db;
	}
	public Ciudad ciudadMasCalurosa() {
		Ciudad c = null;
		String linea = "";
		//return st.max((a,b)->a.getEdad()-b.getEdad()).get();
		try(FileReader fr = new FileReader(this.ficherociudades);
				BufferedReader bf = new BufferedReader(fr)) {
				//El comparator metodo compare devuelve un entero por lo que perdería precision puedo hacerlo convirtiendo
				//la salida del comparator a int pero pierdo precision
				linea=bf.lines().max((a,b)-> (int)(Double.parseDouble(a.split("[|]")[1]) - Double.parseDouble(b.split("[|]")[1])))
						.get();
				//Se puede hacer con operador ternario que devuelve el primer o segundo elemento.
				c = new Ciudad(linea.split("[|]")[0],Double.parseDouble(linea.split("[|]")[1]));
				
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return c;
	}		
	public List<Ciudad> recuperarTodas(){
		List<Ciudad>listaciudades = null;
		try(FileReader fr = new FileReader(this.ficherociudades);
				BufferedReader bf = new BufferedReader(fr)) {
				listaciudades=bf.lines()
						.map(s->new Ciudad(s.split("[|]")[0],Double.parseDouble(s.split("[|]")[1])))
						.collect(Collectors.toList());		
		}		
		catch(IOException e) {
			e.printStackTrace();
		}
		return listaciudades;
	}

}
