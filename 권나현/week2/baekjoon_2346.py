import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
deq = deque(enumerate(map(int, input().split()), start=1))

result = []

while deq:
    idx, move = deq.popleft()
    result.append(idx)
    
    if deq:
        if move > 0:
            deq.rotate(-(move - 1))
        else:
            deq.rotate(-move)
print(*result)