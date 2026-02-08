import sys
input = sys.stdin.readline

n, m = map(int, input().split())
lst = [1]
d = {}

for i in range(1, n+1):
    name = input().strip()
    lst.append(name)
    d[name] = i
for i in range(m):
    question = input().strip()
    if question.isdigit():
        print(lst[int(question)])
    else:
        print(d[question])