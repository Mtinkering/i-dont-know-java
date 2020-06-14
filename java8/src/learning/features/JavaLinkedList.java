package learning.features;

import java.util.LinkedList;

public class JavaLinkedList {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<>();

		ll.add("Hello");
		ll.add("world");

		ll.remove("yo");
		ll.size();
		System.out.println(ll);
	}
}
