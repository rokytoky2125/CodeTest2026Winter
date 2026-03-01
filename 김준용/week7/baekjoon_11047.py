with open(r"C:\Users\glado\Documents\EOF testing.txt") as file:
    filed = file.read().splitlines()

#import sys
#filed = sys.stdin.read().splitlines()
_, goal = filed[0].split()
del filed[0]
goal = int(goal)
coins = 0

filed = reversed(tuple(map(int, filed)))
for i in filed:
    specific_coin_count = 0
    if i <= goal:
        specific_coin_count = goal // i
        goal -= specific_coin_count*i
        coins+=specific_coin_count
    if goal == 0:
        break
print(coins)