import PrimeNumbers
def evaluatePolinomial(a, b, n):
	return n * (n + a) + b

def main():
	primes = PrimeNumbers.PrimeNumbers()
	max = 0
	max_a = None
	max_b = None
	for a in range(-999,1000):
		print a
		for b in range(-999,1000):
			n = 0
			while primes.is_prime(evaluatePolinomial(a, b, n)):
				n += 1
				if max < n:
					max = n
					max_a = a
					max_b = b
	print max
	print max_a
	print max_b
main()