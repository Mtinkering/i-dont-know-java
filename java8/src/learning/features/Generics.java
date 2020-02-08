package learning.features;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Generics {
	public static void main(String[] args) {
		List list = new LinkedList();

		list.add(new Integer(1));

		Integer i	= (Integer) list.iterator().next();


		List<Integer> list2 = new LinkedList<>();
		list2.add(new Integer(2));

		Integer i2 = list2.iterator().next();

		List<House> houses = new LinkedList<>();
		paintAllBuildings(houses);


		List<Integer> l3 = new ArrayList<>();
		l3.add(1);

		int x = l3.get(0);
	}


//	? extends Building: // Building and its subclasses
	public static void paintAllBuildings(List<? extends Building> buildings) {
		buildings.forEach(Building::paint);
	}

	// Type Erasure: To make sure that after compile time, it's a concrete type
	public <T> List<T> genericMethod(List<T> list) {
		return list.stream().collect(Collectors.toList());
	}

	// Illustration: Type is unbounded, so its upper bound is Object
	public List<Object> genericMethod2(List<Object> list) {
		return list.stream().collect(Collectors.toList());
	}

	// By default, it's object
//	public List genericMethod3(List list) {
//		return list.stream().collect(Collectors.toList());
//	}

	// GENERICS RESTRICTION:
	// - Type param can't be primitive. <Integer>, not <int>
}
