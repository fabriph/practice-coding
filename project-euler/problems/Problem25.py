import math
import decimal

i = 3
a = 1  # F(1)
b = 1  # F(2)
while(True):
	c = a + b
	if (len(str(c)) >= 1000):
		print "found at " + str(i)
		break

	i += 1
	a = b
	b = c