import sys
filed = sys.stdin.read().splitlines()
del filed[0]
filed = tuple(map(int, filed))
filed = sorted(filed,reverse=True)
filed = [filed[i:i + 3] for i in range(0, len(filed), 3)]

payment = 0
for prices in filed:
    if len(prices) == 3:
        payment += sum(prices) - min(prices)
    else:
        payment += sum(prices)

print(payment)