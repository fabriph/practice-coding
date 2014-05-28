"""
Possible optimization: don't keep the whole string in memmory, just strip it
from time to time. Keep only the values.
"""
def main():
	string = ""
	number = 1
	while len(string) < 1000001:
		string += str(number)
		number += 1
	print int(string[1-1]) * int(string[10-1]) * int(string[100-1]) * int(string[1000-1]) * int(string[10000-1]) * int(string[100000-1]) * int(string[1000000-1])

main()

