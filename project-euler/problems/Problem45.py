def generateAllHexagonalsUntil(max):
	n = 1
	value = 0
	map = {}
	while (value < max):
		value = n*(2*n-1)
		n += 1
		map[value] = 1
	return map

# its better to try to pollute the hashes as less as possible
MAX = 10000000000
numbersGenerated = generateAllHexagonalsUntil(MAX)
#print sorted(numbersGenerated.keys())

n = 1
value = 0
while (value < MAX):
	value = n * (3*n-1) / 2
	n += 1
	if value in numbersGenerated:
		numbersGenerated[value] = 2

n = 1
value = 0
while (value < MAX):
	value = n * (n+1) / 2
	n += 1
	if value in numbersGenerated:
		if numbersGenerated[value] == 2:
			print value