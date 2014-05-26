"""
Up to 1.000.000
there are 10 * (3 + 3 + 2 + 2 + 1) = aprox 110 base 10 palindromes
there are  2 * (10 + 9*2 + 8*2 + ... + 2*2 + 1) = 200 aprox base 2 palindromes

So its better to build base 10 palindromes, and then check if those are base 2 palindromes 

NOT INCLUDE LEADING ZEROS
"""

"""
Builds a palindrome number according to the input numbers, and if you want it to be odd digits or not
Ex: [1, 2, 3]  odd:      32123
    [7, 8, 9] even:     987789"""
def palindrometize(digits_used, is_odd):
	if is_odd:
		result = digits_used[0] * 10**(len(digits_used) - 1)
		small = 10**(len(digits_used) - 2)
		big = 10**len(digits_used)
		i = 1
	else:
		result = 0
		small = 10**(len(digits_used) - 1)
		big = 10**len(digits_used)
		i = 0
	while i < len(digits_used):
		result += digits_used[i] * big + digits_used[i] * small
		small = small / 10
		big *= 10
		i += 1
	return result

def toBase2(number):
	return bin(number)[2:]

def isPalindrome(number):
	if len(number) <= 1:
		return True
	if number[0] != number[-1]:
		return False
	return isPalindrome(number[1:-1])

def buildPalindromes(length, digits_used, is_odd):
	if length == len(digits_used):
		if digits_used[-1] != 0:
			number = palindrometize(digits_used, is_odd)
			if isPalindrome(toBase2(number)):
				global sum
				sum += number
			#else:
	else:
		for x in range(10):
			temp = list(digits_used)
			temp.append(x)
			buildPalindromes(length, temp, is_odd)


def main():
	for length in range(1,7):
		buildPalindromes((length + 1) / 2, [], length % 2 == 1)

sum = 0
main()
print sum