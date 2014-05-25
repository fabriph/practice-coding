import PrimeNumbers

def is_circular_prime(primes, number):
	number = str(number)
	tries = 0
	while tries < len(number):
		if not primes.is_prime(int (number)):
			return False
		number = number[1:] + number[0]
		tries += 1
	return True

def main():
	primes = PrimeNumbers.PrimeNumbers()
	number = primes.get_prime(0)
	count = 0
	i = 0
	while number < 1000000:
		if is_circular_prime(primes, number):
			count += 1
		i += 1
		number = primes.get_prime(i)
	print count

main()