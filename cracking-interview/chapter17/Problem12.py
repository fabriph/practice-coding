def main(array, sum):
	dict = {}
	for x in array:
		dict[x] = True
	for x in array:
		if x > sum / 2:
			continue
		if sum - x in dict:
			print x,
			print sum - x

main([1,2,3,10,11,12],12)