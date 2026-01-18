mod = input().strip().split('-')
result = 0
result += sum(map(int, mod[0].strip().split('+')))

for i in range(1, len(mod)):
    result -= sum(map(int, mod[i].strip().split('+')))
print(result)