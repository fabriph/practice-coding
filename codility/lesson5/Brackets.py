N = 200001
stack = [0] * N
size = 0

def push(x):
	global size
	stack[size] = x
	size += 1

def pop():
	global size
	if size ==0:
		return -1
	size -= 1
	return stack[size]

def solution(S):
	mirror = {")": "(" ,"}": "{" ,"]": "["}
	for c in S:
		if c in "([{":
			push(c)
		else:
			partner = pop()
			if partner == -1:
				return 0
			if not mirror[c] == partner:
				return 0
	global size
	if size > 0:
		return 0
	return 1

s = "{[()()]}"
print solution(s)