import time
import math

def division(number):
	result = 1
	while number >= 10:
		number = number / 10
		result += 1
	return result

def many_ifs(number):
	if number < 10:
		return 1
	if number < 100:
		return 2
	if number < 1000:
		return 3
	if number < 10000:
		return 4
	if number < 100000:
		return 5
	if number < 1000000:
		return 6
	if number < 10000000:
		return 7
	if number < 100000000:
		return 8
	if number < 1000000000:
		return 9
	if number < 10000000000:
		return 10
	return -1

#main()
MAX_NUMBER = 1000

start_time = time.time()
for num1 in range(1, MAX_NUMBER):
	for num2 in range(1, MAX_NUMBER):
		num1 * 10**many_ifs(num1) + num2
print time.time() - start_time, "seconds using num1 * 10**many_ifs(num1) + num2"

start_time = time.time()
for num1 in range(1, MAX_NUMBER):
	for num2 in range(1, MAX_NUMBER):
		num1 * 10**division(num1) + num2
print time.time() - start_time, "seconds using num1 * 10**division(num1) + num2"

start_time = time.time()
for num1 in range(1, MAX_NUMBER):
	for num2 in range(1, MAX_NUMBER):
		num1 * 10**len(str(num1)) + num2
print time.time() - start_time, "seconds using num1 * 10**len(str(num1)) + num2"

start_time = time.time()
for num1 in range(1, MAX_NUMBER):
	for num2 in range(1, MAX_NUMBER):
		num1 * 10**(int(math.log10(num1))+1) + num2
print time.time() - start_time, "seconds using num1 * 10**(int(math.log10(num))+1) +num2"

start_time = time.time()
for num1 in range(1, MAX_NUMBER):
	for num2 in range(1, MAX_NUMBER):
		int(str(num1)+str(num2))
print time.time() - start_time, "seconds using int(str(num1)+str(num2))"
