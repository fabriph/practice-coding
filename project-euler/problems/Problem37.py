import PrimeNumbers

def is_truncable(primes_db, prime):
	left = str(prime)
	right = str(prime)
	while len(left) > 0:
		if not primes_db.is_prime(int(left)):
			return False
		if not primes_db.is_prime(int(right)):
			return False
		left = left[:-1]
		right = right[1:]
	return True
	

def main():
	primes = PrimeNumbers.PrimeNumbers()
	i = 4
	sum = 0
	while i < primes.get_index_of_last_prime():
		if is_truncable(primes, primes.get_prime(i)):
			print primes.get_prime(i)
			sum += primes.get_prime(i)
		i += 1
	print sum

main()