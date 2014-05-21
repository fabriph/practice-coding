import numpy

class PrimeNumbersHolder:
	MAX_COL = 1000
	MAX_ROW = 10
	STEP_GROWING_ROW = 5
	matrix = None
	def getInstance(self):
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

	def binarySearchSecondDimension(self, list, number):
		if len(list) == 1:
			return number == list[0]
		mid = len(list) / 2
		if number < list[mid]:
			return self.binarySearchSecondDimension(list[:mid], number)
		else:
			return self.binarySearchSecondDimension(list[mid:], number)

	def binarySearchFirstDimension(self, start, end, number):
		if start == end:
			return self.binarySearchSecondDimension(self.matrix[start], number)
		mid = (start + end) / 2
		if number < self.matrix[mid][-1]:
			return self.binarySearchFirstDimension(start, mid, number)
		else:
			return self.binarySearchFirstDimension(mid + 1, end, number)

	def isPrime(self, number):
		if number < 2:
			return False
		if self.matrix[-1][-1] < number:
			return False # must raise an exception
		return self.binarySearchFirstDimension(0, len(self.matrix) - 1, number)

	def getIndexOfLastPrime(self):
		return self.MAX_COL * (len(self.matrix) - 1) + len(self.matrix[-1]) - 1

	def getPrime(self, index):
		if index > self.getIndexOfLastPrime():
			return -1 # must raise exception
		row = index / self.MAX_COL
		col = index % self.MAX_COL
		return self.matrix[row][col]

	def printed(self):
		for x in range(0, len(self.matrix)):
			print x, " ", self.matrix[x]
		print

	def getBiggestPrime(self):
		return self.matrix[-1][-1]
