import numpy

class PrimeNumbers:
	MAX_COL = 1000
	MAX_ROW = 10
	STEP_GROWING_ROW = 5
	matrix = None
	def __init__(self):
		self.matrix = [[None for i in range(self.MAX_COL)] for j in range(self.MAX_ROW)]
		current_col = 0
		current_row = 0
		for line in open('primesUpToOneMillion.txt','r'):
			for x in line.split():
				if current_col == self.MAX_COL:
					current_col = 0
					current_row += 1
				if current_row == len(self.matrix):
					self.matrix.extend([[None for i in range(self.MAX_COL)] for j in range(self.STEP_GROWING_ROW)])
				self.matrix[current_row][current_col] = int(x)
				current_col += 1
		while self.matrix[-1][0] == None:
			del self.matrix[-1]
		while self.matrix[-1][-1] == None:
			del self.matrix[-1][-1]

	@staticmethod
	def __check_type(variable):
		if not type(variable) is int:
			raise Exception("Input variable must be integer")

	def __binary_search_second_dimension(self, list, number):
		if len(list) == 1:
			return number == list[0]
		mid = len(list) / 2
		if number < list[mid]:
			return self.__binary_search_second_dimension(list[:mid], number)
		else:
			return self.__binary_search_second_dimension(list[mid:], number)

	def __binary_search_first_dimension(self, start, end, number):
		if start == end:
			return self.__binary_search_second_dimension(self.matrix[start], number)
		mid = (start + end) / 2
		if number < self.matrix[mid][-1]:
			return self.__binary_search_first_dimension(start, mid, number)
		else:
			return self.__binary_search_first_dimension(mid + 1, end, number)

	def __is_prime_division_check(self, number):
		limit = int(number**0.5) + 1
		i = 0
		while self.get_prime(i) < limit:
			if number % self.get_prime(i) == 0:
				return False
			i += 1
		return True

	def is_prime(self, number):
		self.__check_type(number)
		if number < 2:
			return False
		if self.matrix[-1][-1]**2 <= number:
			raise Exception("Prime Numbers: isPrime() out of reach")
		if self.matrix[-1][-1] < number:
			return self.__is_prime_division_check(number)
		return self.__binary_search_first_dimension(0, len(self.matrix) - 1, number)

	def get_index_of_last_prime(self):
		return self.MAX_COL * (len(self.matrix) - 1) + len(self.matrix[-1]) - 1

	def get_prime(self, index):
		self.__check_type(index)
		if index > self.get_index_of_last_prime():
			raise Exception("Prime Numbers: getPrime() index too big")
		row = index / self.MAX_COL
		col = index % self.MAX_COL
		return self.matrix[row][col]

	def printed(self):
		for x in range(0, len(self.matrix)):
			print x, " ", self.matrix[x]
		print

	def get_biggest_prime(self):
		return self.matrix[-1][-1]

	def factorize(self, number):
		self.__check_type(number)
		i = 0
		divisors = []
		prime = self.get_prime(0)
		while prime <= number:
			# maybe optimize: check if temp is prime
			if number % prime == 0:
				number = number / prime
				divisors.append(prime)
			else:
				i += 1
				prime = self.get_prime(i)
		return divisors

	def __colapse(self, factors):
		previous = 0
		output = []
		for x in factors:
			if x == previous:
				output[-1] = output[-1] * x
			else:
				output.append(x)
				previous = x
		return output

	def factorize_colapsed(self, number):
		self.__check_type(number)
		factors = self.factorize(number)
		return self.__colapse(factors)
