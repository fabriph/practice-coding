from Permutations import build_all_permutations
import PrimeNumbers

"""
Be careful, because if library changes and permutations are not built in
increasing order, this might not work as expected.
"""

def check_increasing_sequence(list):
	for a in range(len(list)):
		for b in range(a + 1, len(list)):
			for c in range(b + 1, len(list)):
				if list[b] - list[a] == list[c] - list[b] and list[c] - list[b] != 0:
					print list[a], list[b], list[c], list[b] - list[c]


def main():
	primes = PrimeNumbers.PrimeNumbers()
	sum = 0
	candidates = []
	for a in range(10):
		for b in range(a, 10):
			for c in range(b, 10):
				for d in range(c, 10):
					permutations =  build_all_permutations([str(a), str(b), str(c), str(d)])
					prime_permutations = []
					# Note: permutations are built in increasing sorted order. Because elements are given in increasing order.
					for x in permutations:
						if primes.is_prime(int(x)):
							prime_permutations.append(int(x))
					if len(prime_permutations) > 1:
						candidates.append(prime_permutations)
	for x in candidates:
		check_increasing_sequence(x)

main()