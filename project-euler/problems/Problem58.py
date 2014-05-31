import PrimeNumbers

def main():
	primes = PrimeNumbers.PrimeNumbers()
	number = 9
	length = 5
	primes_count = 3
	number_count = 5
	while (primes_count * 1.0 / number_count) >= 0.1:
		print "ratio", (primes_count * 1.0 / number_count)
		print "length", length
		for x in range(4):
			if primes.is_prime(number):
				primes_count += 1
			number_count += 1
			number += length - 1
		length += 2

main()