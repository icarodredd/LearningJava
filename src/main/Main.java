package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// Comparator + classe anônima + lambda
		List<Person> persons = Arrays.asList(new Person("icarodredd"), new Person("dredd"),
				new Person("Uma pessoa de nome grande!"));

		Comparator<Person> comp = (p1, p2) -> {
			return p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());

		};
		persons.sort(comp);

		// Function
		Function<Person, String> upCase = p -> p.getName().toUpperCase();
		List<String> personUp = persons.stream().map(upCase).collect(Collectors.toList());
		personUp.forEach(p -> System.out.println(p));

		// Predicate
		Predicate<Person> pred = p -> p.getName().equals("Jõao");

	}

}
