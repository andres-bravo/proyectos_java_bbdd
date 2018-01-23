package principal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PruebaStreams {

	public static void main(String[] args) {
		Stream<Integer> numeros=Stream.of(4,8,2,43,3,8,9,0,2,6,7);
		//Stream<Integer>res=numeros.distinct().limit(5);
		//numeros.forEach(n->System.out.println(n));
		//Solo pares sin duplicados
		numeros.distinct().filter(s->s%2==0).forEach(s->System.out.println(s));
		
		//nombres de > 5 chars en mayusculas
		Stream<String> nombres=Stream.of("Juanito","Jose","Luis","Angel","Helena");
		nombres.filter(s->s.length()>5).map(n->n.toUpperCase()).forEach(n->System.out.println(n));
		
		//Prueba peek
		System.out.println("Prueba metodo peek");
		Stream<Integer> numeros3=Stream.of(4,8,2,43,3,8,9,0,2,6,7);
		//peek, operaciones pendientes, en modo lazy cuando se ejecute la operaci�n final.
		numeros3.distinct().peek(s->System.out.println("Impresion peek: " + s)).filter(s->s<=4).forEach(s->System.out.println("Impresion final"+s));
		
		//Ejemplo peek
		System.out.println("Otra prueba peek");
		Stream.of("one", "two", "three", "four")
        .filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());

		//hay alg�n numero par mayor que 10?
		Stream<Integer> numeros2=Stream.of(4,8,2,43,3,8,9,0,2,6,7);
		System.out.println(numeros2.anyMatch(n->(n>10 && n%2==0)));
		
		
		
	}

}
