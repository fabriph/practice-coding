def nextUnused(used, current):
	for i in range(current + 1, current + len(used) + 1):
		if not used[i % len(used)]:
			return i % len(used)
	return "0000" # should raise an exception

def doPermutations(elements, used, part):
	first_unused = -1
	for i in range(len(used)):
		if not used[i]:
			first_unused = i
			break
	if first_unused == -1:
		return [part]
	else:
		result = []
		current = first_unused
		while current != -1:
			used[current] = True
			result.extend(doPermutations(elements, used, part+elements[current]))
			used[current] = False
			# find next element
			current = nextUnused(used, current)
			if current == first_unused:
				break
		return result

def buildAllPermutations(elements):
	print "creating permutations"
	used = [False for x in range(len(elements))]
	return doPermutations(elements, used, "")