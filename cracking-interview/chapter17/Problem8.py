input = [2, -8, 3, -2, 4, -10]
global_sum = 0
prefix_sum = 0
currently_prefix = True

for current in input:
    if currently_prefix:
        if global_sum + current > 0:
            global_sum += current
        else:
            currently_prefix = False
            prefix_sum = 0
    else:
        if prefix_sum + current > 0:
            prefix_sum += current
        else:
            if global_sum < prefix_sum:
                global_sum = prefix_sum

print global_sum