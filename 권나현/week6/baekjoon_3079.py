import sys
input = sys.stdin.readline

n, m = map(int, input().split())
lst = []

for i in range(n):
    k = int(input())
    lst.append(k)

#시간 time으로 m명 이상 탑승 가능 여부 판별
def can(time):
    total = 0
    for i in lst:
        total += time // i
        if total >= m:
            return True
    return False

#이분탐색
start = 1
end = max(lst) * m
answer = 0

while start <= end:
    mid = (start + end) // 2
    if can(mid):
        answer = mid
        end = mid - 1
    else:
        start = mid + 1
        
print(answer)