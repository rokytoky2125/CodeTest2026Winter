import sys
input = sys.stdin.readline

n, m = map(int, input().split())
lengths = list(map(int, input().split()))

#크기 size으로 블루레이 m개 가능 여부 판별
def can(size):
    cnt = 1 #블루레이 개수
    total = 0 #현재 블루레이 사용량
    
    for i in lengths:
        if i > size:
            return False
        
        if total + i <= size:
            total += i
        else:
            cnt += 1
            total = i
            
    return cnt <= m

#이분 탐색
start = 1
end = sum(lengths)
answer = 0

while start <= end:
    mid = (start + end) // 2
    if can(mid):
        answer = mid
        end = mid - 1
    else:
        start = mid + 1
        
print(answer)