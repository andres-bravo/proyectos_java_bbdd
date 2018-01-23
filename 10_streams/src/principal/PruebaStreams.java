package principal;

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
		
		//peek, operaciones pendientes, en modo lazy cuando se ejecute la operación final.
		numeros.distinct().peek(s->System.out.println(s)).count();
		//hay algún numero par mayor que 10?
		Stream<Integer> numeros2=Stream.of(4,8,2,43,3,8,9,0,2,6,7);
		System.out.println(numeros2.anyMatch(n->(n>10 && n%2==0)));
		
		
		
	}

}
