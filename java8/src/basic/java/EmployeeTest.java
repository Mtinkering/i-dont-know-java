package basic.java;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee harry = new Employee("steven");
//		Employee harry = new Employee("harry");

//		Employee boss = new Employee("boss");
//
//		boolean check = harry.equals(boss);
//
//		System.out.println(check);                 // Possible
//		System.out.println(Employee.nextId);
//
//		System.out.println(Employee.getNextId());
//		System.out.println(harry.getNextId());
	}
}

class Employee {
	private String name;
	public static final int nextId = 1;

	public static int getNextId() {
		return nextId;
	}
//
	public Employee(String name) {
		this.name = name;
	}

	public boolean equals(Employee other) {
		// No need getter to access name from other
		return name.equals(other.name);
	}
}