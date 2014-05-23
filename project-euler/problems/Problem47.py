import PrimeNumbers

def all_len_equal(fact, length):
	for x in fact:
		if len(x) != length:
			return False
	return True 

def remove_duplicates_runlenght(input):
	previous = 0
	output = []
	for x in input:
		if x == previous:
			continue
		else:
			output.append(x)
			previous = x
	return output

def are_distinct(fact):
	original_list = []
	for x in fact:
		original_list.extend(x)
	original_list.sort()
	modified_list = remove_duplicates_runlenght(original_list)
	return len(original_list) == len(modified_list)

def main():
	primes = PrimeNumbers.PrimeNumbers()
	current = 5
	DISTINCT_PRIME_FACTORS = 4
	fact = [None] * DISTINCT_PRIME_FACTORS
	for i in range(DISTINCT_PRIME_FACTORS):
		fact[i] = primes.factorize_colapsed(current - 3 + i)

	while True:
		print current
		# Could check that the numbers are not prime.
		if all_len_equal(fact, DISTINCT_PRIME_FACTORS) and are_distinct(fact):
			for i in range(DISTINCT_PRIME_FACTORS):
				print current - i, fact[ - i]
			break
		else:
			current += 1
			fact = fact[1:DISTINCT_PRIME_FACTORS]
			fact.append(primes.factorize_colapsed(current))

main()