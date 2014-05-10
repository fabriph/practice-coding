N = 1000005
stack = [0] * N
size = 0

def push(x):
	global size
	stack[size] = x
	size += 1

def is_empty():
	global size
	return size == 0

def top():
	return stack[size-1]

def pop():
	global size
	if size == 0:
		return -1
	size -= 1
	return stack[size]

def solution(A):
	for element in A:
		if is_empty():
			push(element)
		elif element == top():
			push(element)
		else:
			pop()

	if not is_empty():
		candidate = pop()
		count = 0
		index = -1
		for i in xrange(len(A)):
			if A[i] == candidate:
				count +=1
				index = i
		if count > (len(A)/2):
			return index
	else:
		return -1

a = [3, 4, 3, 2, 3, -1, 3, 3]
print solution(a)