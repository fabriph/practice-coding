package problems;

import java.util.List;

import utils.PrimeNumbers;

public class Problem21 {
	public static void main(String[] args) {
		long amicableNumbersSum = 0;
		long divisors1Sum = 0;
		long divisors2Sum = 0;
		for (int i = 2; i < 10000; i++) {
			divisors1Sum = sum(PrimeNumbers.getDivisors(i)) - i;
			if (i != divisors1Sum && divisors1Sum > 0) {
				divisors2Sum = sum(PrimeNumbers.getDivisors(divisors1Sum))
						- divisors1Sum;
				if (i == divisors2Sum) {
					System.out.println("Founded " + i + " " + divisors1Sum);
					amicableNumbersSum += i + divisors1Sum;
				}
			}
		}
		System.out.println("amicableNumbersSum " + amicableNumbersSum);
	}

	private static long sum(List<Long> divisors) {
		long sum = 0;
		for (Long number : divisors) {
			sum += number;
		}
		return sum;
	}
}
