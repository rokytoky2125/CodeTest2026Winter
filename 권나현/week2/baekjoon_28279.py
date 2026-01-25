import sys
from collections import deque
input = sys.stdin.readline
out = sys.stdout.write

n = int(input())
lst = []

for i in range(n):
    cmd = list(input().split())
    lst.append(cmd)

deq = deque([])
for i in lst:
    if i[0] == "1":
        deq.appendleft(i[-1])
    elif i[0] == "2":
        deq.append(i[-1])
    elif i[0] == "3":
        if len(deq) == 0:
            out(str(-1) + "\n")
        else:
            out(str(deq.popleft()) + "\n")
    elif i[0] == "4":
        if len(deq) == 0:
            out(str(-1) + "\n")
        else:
            out(str(deq.pop()) + "\n")
    elif i[0] == "5":
        print(len(deq))
    elif i[0] == "6":
        if len(deq) == 0:
            out(str(1) + "\n")
        else:
            out(str(0) + "\n")
    elif i[0] == "7":
        if len(deq) == 0:
            out(str(-1) + "\n")
        else:
            out(str(deq[0]) + "\n")
    elif i[0] == "8":
        if len(deq) == 0:
            out(str(-1) + "\n")
        else:
            out(str(deq[-1]) + "\n")