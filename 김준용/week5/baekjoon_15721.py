"""
중앙대학교 소프트웨어학부에 새로 입학한 19학번 새내기 일구는 새내기 새로 배움터에 가서 술게임을 여러 가지 배웠다. 그 중 가장 재미있었던 게임은 바로 번데기 게임이었다.

번데기 게임의 규칙은 다음과 같다. ‘뻔 – 데기 – 뻔 – 데기 – 뻔 – 뻔 – 데기 – 데기’ 를 1회차 문장이라고 하자. 2회차 문장은 ‘뻔 – 데기 – 뻔 - 데기 – 뻔 – 뻔 – 뻔 – 데기 – 데기 – 데기’가 된다. 즉 n-1회차 문장일 때는 ‘뻔 – 데기 – 뻔 – 데기 – 뻔(x n번) – 데기(x n번)’이 된다. 하이픈 사이를 지날 때마다 순서는 다음 사람으로 넘어간다. 원을 돌아 다시 일구 차례가 와도 게임은 계속 진행된다.

일구와 동기들, 그리고 선배들을 포함한 사람 A명이 다음과 같이 원으로 앉아 있다고 가정하자. 
"""
import sys

lookup = sys.stdin.read().splitlines()

how_many_values_before=0
how_many=int(lookup[1])
type=int(lookup[2])
N=2
how_many_present=0

while how_many:
    how_many_present=2+N
    if how_many_present < how_many:
        how_many_values_before+=4+2*N
        N+=1
        how_many-=how_many_present
    else:
        template = map(int,("0 1 0 1"+N*' 0'+N*' 1').split())
        N+=1
        for i in template:
            how_many_values_before+=1
            if i == type:
                how_many-=1
            if not how_many:
                position = how_many_values_before%(int(lookup[0]))-1
                if position == -1:
                    print(int(lookup[0])-1)
                    break
                else:
                    print(position)
                    break





