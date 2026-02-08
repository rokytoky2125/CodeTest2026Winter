n, c = map(int, input().split())
array = []

for i in range(n):
    x = int(input())
    array.append(x)
    
array.sort()

#거리 dist로 공유기 c개 이상 설치 가능 여부 판별
def can_place(dist):
    count = 1 #첫 집에 설치
    last = array[0] #최근 설치한 위치
    
    for i in range(1, n):
        if array[i] - last >= dist:
            count += 1
            last = array[i]
    return count >= c

#이분 탐색
start = 1
end = array[-1] - array[0]
answer = 0

while start <= end:
    mid = (start + end) // 2
    
    if can_place(mid):
        answer = mid
        start = mid + 1
    else:
        end = mid - 1

print(answer)