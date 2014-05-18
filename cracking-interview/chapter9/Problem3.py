# Find ONE magic index
# I cant use slices in this exercise, It'd change the exercise
def findMagicIndex(array, start, end):
	if start < array[start]:
		return None
	if start == end:
		return start if array[start]==start else None
	mid = (start + end) / 2
	if mid <= array[mid]:
		return findMagicIndex(array,start,mid)
	else:
		return findMagicIndex(array,mid+1,end)


#array = [2,4,6,8] # result none
array = [-2,0,2,4] # result: 2
#array = [-1,0,1,2,4] # result: 4
#array = [0,20,30] # result: 0
print findMagicIndex(array, 0, len(array))