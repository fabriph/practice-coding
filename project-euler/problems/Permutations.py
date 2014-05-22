def nextUnused(used, current):
	for i in range(current + 1, current + len(used) + 1):
		if not used[i % len(used)]:
			return i % len(used)
	raise Exception("Permutations: Unexpected internal library error")

def doPermutations(elements, used, part, only_odd_numbers):
	first_unused = -1
	for i in range(len(used)):
		if not used[i]:
			first_unused = i
			break
	if first_unused == -1:
		if only_odd_numbers:
			if int(part[-1]) % 2 == 1:
				return [part]
			else:
				return []
		else:
			return [part]
	else:
		result = []
		current = first_unused
		while current != -1:
			used[current] = True
			result.extend(doPermutations(elements, used, part+elements[current], only_odd_numbers))
			used[current] = False
			# find next element
			current = nextUnused(used, current)
			if current == first_unused:
				break
		return result

def buildAllPermutations(elements, only_odd_numbers = False):
	used = [False for x in range(len(elements))]
	return doPermutations(elements, used, "", only_odd_numbers)
