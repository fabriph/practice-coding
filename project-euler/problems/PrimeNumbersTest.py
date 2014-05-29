import PrimeNumbers

def test(primes, number, expected):
	print "OK" if expected == primes.is_prime(number) else "Fail in ", number

primes = PrimeNumbers.PrimeNumbers()
test(primes, -1, False)
test(primes, 70000, False)
test(primes, 700000000, False)
test(primes, 1000000000000, False)
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
test(primes, 1000117, True)
test(primes, 1000121, True)
test(primes, 1000187, True)
test(primes, 3156649, True)
test(primes, 5758513, True)
test(primes, 7897063, True)
test(primes, 10291223, True)
test(primes, 12616231, True)
test(primes, 14428451, True)
test(primes, 15485863, True)

try:
    primes.get_prime(10**15)
except:
    print "index too big: OK"
else:
    print "Behavour not expected"

print primes.factorize(2)
print primes.factorize(3)
print primes.factorize(226844352)

try:
    primes.is_prime("79")
except:
    print "input parameter not integer: OK"
else:
    print "Behavour not expected: input variable is not integer"