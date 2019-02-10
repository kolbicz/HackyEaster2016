from itertools import permutations

perms = [''.join(p) for p in permutations('9876543210')]
for perm in perms:
    for i in range(1, 11):
		part = perm[:i]
		if int(part) % (i) != 0:
			break
		if i==10:
			print perm