import sys
num = tuple(map(int, sys.stdin.read().split()))
pos = 1
total = 0
template = sum(num[1:])
for i in num[1:]:
    template-=i
    total += template*i
print(total)