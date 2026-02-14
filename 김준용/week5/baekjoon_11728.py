import sys
lines = sys.stdin.read().splitlines()
new_list = []
new_list.extend(map(int, lines[1].split()))
new_list.extend(map(int, lines[2].split()))
new_list.sort()
print(*new_list)
