import sys
num = tuple(map(int, sys.stdin.read().split()))
for i in num[1:]:
    Max = i
    if i == 1:
        print(1)
        continue
    while True:
        if i&1:
            i=i*3+1
            if i > Max:
                Max = i
            i//=2
        else:
            i //= 2
            if i==1:
                break
    print(Max)
