# Inductive approach
sum = 1
lastNumber = 1
MAX_DIMENSION = 1001
for dimension in range(3,MAX_DIMENSION+1,2):
    for corners in range(1,5):
        lastNumber += dimension - 1
        sum += lastNumber

print sum