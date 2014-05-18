def findCombinationsForStairSteps(array, n):
	if array[n] != 0:
		return array[n]
	if n == 0 :
		return 1
	result = 0
	if n >= 3:
		 result = findCombinationsForStairSteps(array, n-3)
	if n >= 2:
		result += findCombinationsForStairSteps(array, n-2)
	result += findCombinationsForStairSteps(array, n-1)
	array[n] = result
	return result

stair_long = 30
array = [0]*(stair_long+1)
findCombinationsForStairSteps(array, stair_long)
print array