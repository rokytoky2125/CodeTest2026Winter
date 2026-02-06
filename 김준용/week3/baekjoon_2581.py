import sys
lower, upper = map(int, sys.stdin.read().split())

factor_list = [2]
if upper == 1:
    print(-1)
    sys.exit()

pos = 0
for i in range(2, upper+1):
    deny=0
    for f in factor_list:
        if not i%f:
            deny=0
            break
        else:
            deny=i
    if deny:
        factor_list.append(deny)
        if (deny < lower):
            pos+=1
if factor_list[0] < lower:
    factor_list = factor_list[pos+1:]
if len(factor_list) > 0:
    print(sum(factor_list))
    print(factor_list[0])
else:
    print(-1)

