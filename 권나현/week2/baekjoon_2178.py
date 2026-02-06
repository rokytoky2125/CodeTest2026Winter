from collections import deque

n, m = map(int, input().split())
maze = []


#미로 구현: 2차원 리스트
for i in range(n):
    row = list(map(int, input().strip()))
    maze.append(row)

#print(maze)
def bfs(start_x, start_y):
    count = 0
    queue = deque()
    queue.append((start_x, start_y))
    
    visited = [[False] * m for _ in range(n)]
    visited[start_x][start_y] = True
    
    #상하좌우
    dx = [-1, 1, 0, 0] #행: -1은 위쪽, +1은 아래쪽
    dy = [0, 0, -1, 1] #열
    
    while queue:
        x, y = queue.popleft() #큐에서 하나 꺼내기
        #print("현재 위치:", x, y)
        
        #인접한 노드(좌표) 탐색
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            #범위 확인 + 방문 여부 확인
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and maze[nx][ny] == 1:
                visited[nx][ny] = True
                queue.append((nx, ny)) #큐에 추가
                maze[nx][ny] = maze[x][y] + 1
    print(maze[n-1][m-1])

bfs(0,0)