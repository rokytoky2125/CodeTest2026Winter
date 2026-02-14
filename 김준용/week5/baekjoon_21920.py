import sys
import math
values = sys.stdin.read().splitlines()
compare = int(values[2])
middle = tuple(map(int, values[1].split()))

avg=0
avg_count=0
for i in middle:
    if math.gcd(i,compare) == 1:
        avg+=i
        avg_count+=1
print(avg/avg_count)