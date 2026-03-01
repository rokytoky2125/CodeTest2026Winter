import sys
filed = sys.stdin.read().splitlines()
del filed[0]
for number in filed:
    n = int(number)

    x = n // 5
    y = x 

    while x > 0:
        x //= 5
        y += x
    
    print(y)
#TODO: Come back later to understand the code again. Lord knows I don't know why this works.