#Get total values
#get list of values
#find the smallest value (use sorting)
#find the factors of the smallest value
#see if the rest of the list can be divided
from functools import reduce
T = int(input())
vl = sorted(map(int, input().split()))
SV = vl[0]
del vl[0]
#https://stackoverflow.com/questions/6800193/what-is-the-most-efficient-way-of-finding-all-the-factors-of-a-number-in-python 에서 펙터링 코드 갖어옴 (수정 포함) 필요시 설명 가능
SVF = set(reduce(list.__add__, [[i, SV//i] for i in range(1, int(SV**0.5) + 1) if not SV % i]))
[print(i) for i in sorted(SVF) if all([not j % i for j in vl])]
