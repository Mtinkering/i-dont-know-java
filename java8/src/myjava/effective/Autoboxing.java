package myjava.effective;

public class Autoboxing {

	// Each time the i is added to sum, there is autoboxing.
	// We should prefer primitives to boxed primitives
	private static long sumDamnLong() {
		Long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++)
			sum += i;
		return sum;
	}

	private static long sumDamnFast() {
		long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++)
			sum += i;
		return sum;
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		sumDamnLong();
		long elapsedTime = System.nanoTime() - startTime;

		System.out.println("Total execution time in Java in millis: "
				+ elapsedTime/1000000);

		startTime = System.nanoTime();
		sumDamnFast();
		elapsedTime = System.nanoTime() - startTime;

		System.out.println("Total execution time in Java in millis: "
				+ elapsedTime/1000000);
	}
}
