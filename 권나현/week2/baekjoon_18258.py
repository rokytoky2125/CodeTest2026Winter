import sys
from collections import deque
input = sys.stdin.readline

lst = []

n = int(input())
for i in range(n):
    s = input()
    lst.append(s)

queue = deque([])
for i in lst:
    l = list(i.split())
    if l[0] == "push":
        queue.append(int(l[-1]))
    elif l[0] == "pop":
        if len(queue) < 1:
            print(-1)
        else:
            print(queue.popleft())
    elif l[0] == "size":
        print(len(queue))
    elif l[0] == "empty":
        if len(queue) < 1:
            print(1)
        else:
            print(0)
    elif l[0] == "front":
        if len(queue) < 1:
            print(-1)
        else:
            print(queue[0])
    elif l[0] == "back":
        if len(queue) < 1:
            print(-1)
        else:
            print(queue[-1])
    
