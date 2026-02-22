import sys
input = sys.stdin.readline

k, n = map(int, input().split())
lst = []

for i in range(k):
    b = int(input())
    lst.append(b)
    
#길이 length로 n개 이상 설치 가능 여부 판별
def can_place(length):
    count = 0
    for i in lst:
        count += i // length
    if count < n:
        return False
    else:
        return True
    
#이분 탐색
start = 1
end = max(lst)
answer = 0

while start <= end:
    mid = (start + end) // 2
    
    if can_place(mid):
        answer = mid
        start = mid + 1
    else:
        end = mid - 1

print(answer)