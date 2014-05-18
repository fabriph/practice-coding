map = {}
for a in range(2,101):
    for b in range(2,101):
        map[a**b] = True

print len(map.keys())