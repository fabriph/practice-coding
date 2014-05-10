A = [-3, 1, 2, -2, 5, 6]
"""selected = A[:3]
selected.sort()
pending = A[3:]

for element in pending:
	if element > selected[0]:
		selected[0] = element
		selected.sort()

print selected
"""
A.sort()

result1 = A[-1] * A[-2] * A[-3]
result2 = A[0] * A[1] * A[2]

return max(result1, result2)