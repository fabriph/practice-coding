import PrimeNumbers

def test(primes, number, expected):
	print "OK" if expected == primes.isPrime(number) else "Fail in ", number

primes = PrimeNumbers.PrimeNumbersHandler()
test(primes, -1, False)
test(primes, 1000000000000, False)
test(primes, 70000, False)
test(primes, 3, True)
test(primes, 5, True)
test(primes, 7, True)
test(primes, 11, True)
test(primes, 13, True)
test(primes, 262511, True)
test(primes, 382663, True)
test(primes, 383281, True)
test(primes, 605147, True)
test(primes, 891101, True)
test(primes, 1000003, True)
test(primes, 1000099, True)