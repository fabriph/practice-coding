"""
input = [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]

Find "m":
1- Run from left to right, as long as you can, stop when you find the first non
ordered element. Mark this position as I.
2- From that point until the end, scan for the minimum element.
3- Do binary search from 0 to I with the minimum. The point where the minimum
should be is the "m" asked by the problem.

Find "n":
1- Run from right to left, as long as you can, stop when you find the first non
ordered element. Mark this position as J.
2- From that point until the begining, scan for the maximum element.
3- Do binary search from J to end with the maximum. The point where the maximum
should be is the "n" asked by the problem.

Time complexity:
O(n + n + log n +  n + n + log n) = O(n)
Space complexity:
O(1)
"""