package learning.features;

import java.util.ArrayList;
import java.util.List;

public class AList {
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		l1.add(1);

		l1.size();

		String str = "123";
		str.length();


		char[] chars = str.toCharArray();
		int y = chars.length;

		l1.add(3);

		l2.add(1);
		l2.add(3);
		System.out.println(l1.equals(l2));
	}
}
