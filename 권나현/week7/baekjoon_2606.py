import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
s = int(input())
graph = [[] for _ in range(n+1)]

for i in range(s):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    
def bfs(start):
    visited = [False]*(n+1)
    queue = deque([start])
    visited[start] = True
    cnt = 0
    
    while queue:
        c = queue.popleft() #큐에서 하나 꺼내기
        
        for nc in graph[c]:
            if not visited[nc]:
                visited[nc] = True
                queue.append(nc)
                cnt += 1
    return cnt
        
print(bfs(1))