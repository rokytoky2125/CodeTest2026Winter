import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
targets = list(map(int, input().split()))
queue = deque(range(1, n+1))

count = 0

for target in targets:
    idx = queue.index(target)

    if idx <= len(queue) // 2:
        while queue[0] != target:
            queue.append(queue.popleft())
            count += 1
    else:
        while queue[0] != target:
            queue.appendleft(queue.pop())
            count += 1

    queue.popleft()

print(count)