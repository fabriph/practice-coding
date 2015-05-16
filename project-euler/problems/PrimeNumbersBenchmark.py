import time
import PrimeNumbers

MAX_NUMBER = 10000000

start_time = time.time()
for x in range(MAX_NUMBER):
	primes.get_prime(x)
print time.time() - start_time, "seconds"