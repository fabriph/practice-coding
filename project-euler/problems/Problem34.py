import math

def sumDigitsAsFactorials(number):
	sum = 0
	for digit in str(number):
		sum += math.factorial(int(digit))
	return sum

def main():
	sum = 0
	x = 3
	while x < 10**6:
		if x == sumDigitsAsFactorials(x):
			sum += x
		x += 1
	print sum

main()