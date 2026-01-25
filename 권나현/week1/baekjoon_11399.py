n = int(input())
lst = list(map(int, input().split()))
lst.sort()

count = 0
result = 0

for i in lst:
    count += i
    result += count
    
print(result)