package org.eclipse.main;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.eclipse.classes.Text;
import org.eclipse.interfaces.Calcul;
import org.eclipse.interfaces.Message;
import org.eclipse.interfaces.ShowText;
import org.eclipse.interfaces.Vehicule;

public class Main {

	public static void main(String[] args) {
		
//		Vehicule v1 = new Vehicule() {
//			@Override
//			public void rouler() {
//				System.out.println("v1 roule !");
//			}
//		};
	
//		v1.rouler();
		
//		Vehicule v2 = new Vehicule() {		
//			@Override
//			public void rouler() {
//				System.out.println("v2 roule !");			
//			}
//		};
//		v2.rouler();
		
		// L'expression Lambda est particulièrement utile lorsque le traitement n'est utile
		// qu'une seule fois : elle évite d'avoir à écrire une méthode dans une classe.
		
		Vehicule v3 = (type) -> System.out.println(type);
		
		v3.rouler("v3 roule !");
		
		Calcul addition = (x, y) -> x + y;
		
		// en Java 8 on peut passer des varaibles qui referencent des fonctions 
		// et les passer en tant que parametre
		System.out.println("8 + 2 = " + calculer(8, 2, addition));
		
		Calcul soustraction = (x, y) -> x - y;
		System.out.println("8 - 2 = " + calculer(8, 2, soustraction));
		
		Calcul multiplication = (x, y) -> {
			return x * y;
		};
		
		System.out.println("8 * 2 = " + calculer(8, 2, multiplication));

		Calcul division = (x, y) -> x / y;
		System.out.println("8 / 2 = " + calculer(8, 2, division));
		
		List<String> sports = Arrays.asList("Foot", "Tennis", "Basket");
		
		sports.forEach((sport) -> System.out.println(sport));
		// Il n'est nullement necessaire de passer les parametres,
		// le systeme s'en chargera
		sports.forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(1, 3, 5, 8);
		
		numbers.forEach((num) -> System.out.println(num));
		
		// Consumer<T> : opération qui accepte un unique argument (type T) et ne
		// retourne pas de résultat.
		// Consumer<T> : un paramètre , sans résultat
		
		Consumer<Integer> function1 = (num) -> System.out.println(num);
		
		numbers.forEach(function1);
		
		// Supplier<T> : un return , pas de paramètre, c’est un fournisseur de résultat
		Supplier<Double> random = () -> Math.random();
		
		System.out.println("Random value 1 : " + random.get());
		System.out.println("Random value 2 : " + random.get());
		System.out.println("Random value 3 : " + random.get());
		
		Supplier<LocalDateTime> date1 = () -> LocalDateTime.now();
		System.out.println("Date / Heures : " + date1.get());
				
		// Function <T,R> : Operation qui accepte un unique argument (type T) et
		// retourne un resultat		
		Function<String, String> function2 = (value) -> value.toUpperCase();
		Function<String, String> function3 = (value) -> value.toLowerCase();
		
		System.out.println("Value to Uppercase : " + function2.apply("boNjOUr"));
		System.out.println("Value to Lowercase : " + function3.apply("boNjOUr"));
		
		Function<Integer, Integer> function4 = (value) -> ++value;
		
		System.out.println("Integer PreIncrement : " + function4.apply(1));
		
		// Predicate <T> : un paramètre, résultat de type booléen		
		Predicate<Double> function5 = (x) -> x > 10;
		
		System.out.println(function5.test(-20d));
		
		System.out.println(function5.test(Double.valueOf(-15)));
		
		// Le corps de la lambda ne definit pas de nouveau scope (portée des variables)
		// il est le meme que le scope englobant
		// String a = "";
		
		// BiFunction <T,U,R> : deux paramètres, un résultat
		BiFunction<String, String, String> instead = (param1, param2) -> {
			String a = param1.replace(param2, "b");		
			return a;
		};
		
		System.out.println(instead.apply("abcde", "c"));
		
		// Référence à une méthode de classe (statique).
		Message m1 = Main::showMsg;
		m1.show();
			
		// Référence à une méthode d’instance (non statique).
		// On passe par un objet de classe à savoir ici "main" objet de la 
		// la classe "Main"
		Main main = new Main();
		Message m2 = main::showMsg2;
		m2.show();
		
		// Référence à une méthode non statique à l'aide d'un objet anonyme
		Message m3 = new Main()::showMsg2;
		m3.show();
		
		// Référence à un constructeur
		// référencer un constructeur en utilisant le mot-clé « new »		
		ShowText sText = Text::new;
		sText.getText("Hello from ref constructor");
		
		Text t = new Text();
		t.getText("hello");
					
	}
	
	private static void message() {
		System.out.println("Je suis un message");
	}
	
	private static void showMsg() {
		System.out.println("Message form static method");
	}
	
	private void showMsg2() {
		System.out.println("Message form instance method");
	}
	
	private static int calculer(int x, int y, Calcul operation) {
		return operation.calc(x, y);
	}
	
	private static int calculer2(int x, int y, Calcul operation2) {
		return operation2.calc(x, y);
	}
	
	public static void convertString(Function<String, String> function) {
		System.out.println(function.apply("StRaNgE"));
	}


}