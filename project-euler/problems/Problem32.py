from Permutations import build_all_permutations

def evaluate(permutations):
	map = {}
	print "evaluating permutations"
	for x in permutations:
		for mult_pos in range(1,7):
			for equal_pos in range (mult_pos +1, 8):
				if int(x[:mult_pos]) * int(x[mult_pos:equal_pos]) == int(x[equal_pos:]):
					print x[:mult_pos], "*", x[mult_pos:equal_pos], "=", x[equal_pos:]
					map[x[equal_pos:]] = None
	return map

def main():
	print "Totally bruteforced, feeling hardcore"
	permutations = build_all_permutations(['1','2','3','4','5','6','7','8','9'])
	sum = 0
	for x in evaluate(permutations).keys():
		sum += int(x)
	print sum

main()
