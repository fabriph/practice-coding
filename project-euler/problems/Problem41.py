"""
Other approach could be, given all the primes, start trying from the largets 9 digit in decreasing order, if its a pandigital. It's much better than this approach.
"""
import PrimeNumbers
from Permutations import build_all_permutations

def main():
	print "Initializing primes"
	primes = PrimeNumbers.PrimeNumbers()
	elements = ['1','2','3','4','5','6','7','8','9']
	for length in range(9, 3, -1):
		print "Building permutations of ", elements
		candidates = build_all_permutations(elements, True)
		print "Evaluting result"
		number = 0
		i = -1
		while i > -len(candidates):
			number = int(candidates[i])
			if primes.is_prime(number):
				print "Found"
				print number
				return
			i -= 1
		elements = elements[:-1]

main()