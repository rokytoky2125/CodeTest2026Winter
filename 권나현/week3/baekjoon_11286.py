import sys
import heapq

input = sys.stdin.readline
heap = []

n = int(input())
for i in range(n):
    x = int(input())
    if x == 0:
        if heap:
            abs_v, real_v = heapq.heappop(heap)
            print(real_v)
        else:
            print(0)
            
    else:
        heapq.heappush(heap, (abs(x), x))