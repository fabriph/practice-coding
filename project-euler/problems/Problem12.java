package problems;

import utils.PrimeNumbers;

public class Problem12 {
	static int MAX = 1000000;

	public static void main(String args[]) {
		long sum = 0;
		long startTime = System.currentTimeMillis();
		for (int i = 1; i <= MAX; i++) {
			sum += i;
			if (PrimeNumbers.countDivisors(sum) > 500) {
				System.out.println("DONE number: " + sum + " divisors "
						+ PrimeNumbers.countDivisors(sum));
				break;
			}
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("time is " + elapsedTime);
	}
}
