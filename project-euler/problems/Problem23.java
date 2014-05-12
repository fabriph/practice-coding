package problems;

import java.util.LinkedList;
import java.util.List;

import utils.PrimeNumbers;

public class Problem23 {

	public static void main(String[] args) {
		List<Long> abundantNumbers = findAbundantNumbers(1, 28123);

		// Find the sum of all the positive integers which cannot be written as
		// the sum of two abundant numbers.
		long resultSum = 0;

		// Brute force approach. It takes too long.
		// TODO code a better(faster and more intelligent) way, there are many.
		for (long number = 1; number <= 28123; number++) {
			System.out.println(number + "?");
			boolean canBeWritenAsSum = false;
			for (Long abundantFirst : abundantNumbers) {
				if (abundantFirst > number) {
					break;
				}
				if (canBeWritenAsSum) {
					break;
				}
				// abundantSecond should start from the current value of
				// abundantFirst
				for (Long abundantSecond : abundantNumbers) {
					if (abundantFirst.longValue() + abundantSecond.longValue() == number) {
						canBeWritenAsSum = true;
						break;
					}
				}
			}
			if (canBeWritenAsSum == false) {
				resultSum += number;
			}
		}
		System.out.println(resultSum);
	}

	private static List<Long> findAbundantNumbers(long from, long to) {
		List<Long> result = new LinkedList<Long>();
		List<Long> divisors = null;
		long sum = 0;
		for (long i = from; i <= to; i++) {
			divisors = PrimeNumbers.getProperDivisors(i);
			sum = sumDivisors(divisors);
			if (sum > i) {
				result.add(i);
			}
		}
		return result;
	}

	private static long sumDivisors(List<Long> divisors) {
		long sum = 0;
		for (Long l : divisors) {
			sum += l.longValue();
		}
		return sum;
	}
}
