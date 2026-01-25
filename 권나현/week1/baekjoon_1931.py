n = int(input())
lst = []
end = 0
count = 0

for i in range(n):
    s, t = map(int, input().split())
    lst.append((s,t))

lst.sort(key=lambda x: (x[1], x[0]))

for s, t in lst:
    if s >= end:
        count += 1
        end = t

print(count)