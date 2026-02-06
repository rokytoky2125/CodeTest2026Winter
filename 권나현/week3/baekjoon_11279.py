import sys
import heapq

input = sys.stdin.readline
heap = []

n = int(input())
for i in range(n):
    s = int(input())
    if s == 0:
        if heap:
            print(-heapq.heappop(heap))
        else:
            print(0)
            
    elif s > 0:
        heapq.heappush(heap, -s)