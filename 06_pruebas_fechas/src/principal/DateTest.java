package principal;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTest {

	public static void main(String[] args) {
		//utilizo paquete java.util para este ejemplo
		Date d = new Date();
		System.out.println(d);
		//Fecha de hace dos dias
		Date d2 = new Date(d.getTime()-1000*60*60*24*2);
		System.out.println("Fecha hace dos días: " + d2);
		//Clase Calendar, también java.util fechas más modernas
		//Clase abstracta con metodo static que me devuelve su implementacion en clase Calendar que puedo usar
		Calendar cal = Calendar.getInstance();
		//Para ver datos tiene metodo get con Constantes enteras que le paso por parámetro 
		System.out.println("Año:"+cal.get(Calendar.YEAR));
		System.out.println("Mes:"+cal.get(Calendar.MONTH));
		System.out.println("Día Mes:"+cal.get(Calendar.DAY_OF_MONTH));
		//Le paso un date y me establece un calendar
		cal.setTime(d2);
		//Formateado de fechas
		//Mas comodo que Calendar concatenando y sacando campos
		//java.text.DateFormat
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale("es","ES"));
		System.out.println(df.format(d));
		
	}

}
