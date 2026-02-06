from collections import deque

n, k = map(int, input().split())

def bfs(cur_x, level):
    MAX = 100000
    queue = deque()
    queue.append((cur_x, level))
    
    visited = [False for _ in range(MAX + 1)]
    visited[cur_x] = True
    
    while queue:
        x, level = queue.popleft() #언패킹
#         print("현재 위치:", x)
        if x == k:
            return (x, level)
        
        #인접한 노드 탐색
        options = [x+1, x-1, x*2]
        for i in range(3):
            nx = options[i]
            
            #범위 확인 + 방문 여부 확인
            if 0 <= nx <= MAX and not visited[nx]:
                visited[nx] = True
                queue.append((nx, level + 1)) #큐에 추가
                if nx == k:
                    return (nx, level + 1)
#         print(nx, level)
    
s = bfs(n, 0)
print(s[1])
