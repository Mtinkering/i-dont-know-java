package learning.features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AnArray {
	public static void main(String[] args) {
		Student[] arr = {
			new Student(1, "hung"),
			new Student(2, "steven")
		};

		Arrays.sort(arr, new SortByRoll());

		for (Student s: arr) {
			System.out.println(s);
		}
	}


	private static class Student {
		private int rollNo;

		private String name;

		public Student(int rollNo, String name) {
			this.rollNo = rollNo;
			this.name = name;
		}

		public String toString()
		{
			return this.rollNo + " " + this.name;
		}
	}

	private static class SortByRoll implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.rollNo - o2.rollNo;
		}
	}
}
