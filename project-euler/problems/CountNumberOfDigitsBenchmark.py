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
for x in range(1, MAX_NUMBER):
	for y in range(1, MAX_NUMBER):
		division(x) + division(y)
print time.time() - start_time, "seconds using division()"

start_time = time.time()
for x in range(1, MAX_NUMBER):
	for y in range(1, MAX_NUMBER):
		many_ifs(x) + many_ifs(y)
print time.time() - start_time, "seconds using many_ifs()"

start_time = time.time()
for x in range(1, MAX_NUMBER):
	for y in range(1, MAX_NUMBER):
		len(str(x) + str(y))
print time.time() - start_time, "seconds using len(str() + str())"

start_time = time.time()
for x in range(1, MAX_NUMBER):
	for y in range(1, MAX_NUMBER):
		len(str(x)) + len(str(y))
print time.time() - start_time, "seconds using len(str()) len(str())"

start_time = time.time()
for x in range(1, MAX_NUMBER):
	for y in range(1, MAX_NUMBER):
		int(math.log10(x)) + 1 + int(math.log10(y))+1
print time.time() - start_time, "seconds using math.log10()"
