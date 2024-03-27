package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Comparator + classe anônima + lambda
		List<Person> persons = Arrays.asList(new Person("icarodredd"), new Person("dredd"),
				new Person("Uma pessoa de nome grande!"));

		Comparator<Person> comp = (p1, p2) -> {
			return p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());

		};
		persons.sort(comp);
		for (Person item : persons) {
			System.out.println(item);
		}

	}

}
