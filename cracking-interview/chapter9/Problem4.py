# For simplicity, I'll assume that elements are unique.
def getSubsets(set):
	if len(set) == 1:
		return [[],list(set)]
	else:
		subsets = getSubsets(set[0:-1])
		result = []
		for x in subsets:
			result.append(list(x))
			x.append(set[-1])
			result.append(x)
		return result

print getSubsets(['a','b','c'])