import PrimeNumbers

def main(limit):
	primes = PrimeNumbers.PrimeNumbers()
	i = primes.get_index_of_last_prime()
	# Find first candidate:
	while primes.get_prime(i) > limit:
		i -= 1
	j = i
	max_lenght = 0
	max_prime = 0
	sum = primes.get_prime(i)
	while i > 0:
		while sum < limit and i > 0:
			i -= 1
			sum += primes.get_prime(i)
			if sum < limit and j - i + 1 > max_lenght and primes.is_prime(sum):
					max_prime = sum
					max_lenght = j - i + 1
					print "Local max prime ", max_prime,
					print " lenght ", max_lenght
		j -= 1
		i = j
		sum = primes.get_prime(j)

	print
	print "max_prime ", max_prime
	print "max_lenght ", max_lenght

main(999999)