n = int(input())
l = list(map(int, input().split()))
p = list(map(int, input().split()))

min_p = p[0]
total_p = 0

for i in range(len(l)):
    if p[i] < min_p:
        min_p = p[i]
    total_p += min_p * l[i]
        
print(total_p)
