import time
def sumDigits(number):
	sum = 0
	for digit in str(number):
		sum += int(digit)
	return sum

def main1():
	max = 0
	for x in range(100):
		number = 1
		for exp in range(100):
			number *= x
			sum = sumDigits(number)
			if sum > max:
				max = sum
	print max

def main2():
	max = 0
	for x in range(100):
		for exp in range(100):
			sum = sumDigits(x**exp)
			if sum > max:
				max = sum
	print max

def main3():
	max = 0
	for x in range(100):
		number = 1
		exp = 1
		while exp < 100:
			exp += 1
			number *= x
			sum = sumDigits(number)
			if sum > max:
				max = sum
	print max

start_time = time.time()
main1()
print time.time() - start_time, "seconds Main1"
start_time = time.time()
main2()
print time.time() - start_time, "seconds Main2"
start_time = time.time()
main3()
print time.time() - start_time, "seconds Main3"