word = input().lower()
freq = {}

for c in word:
    freq[c] = freq.get(c, 0) + 1
max_count = 0
result = '?'

for c, cnt in freq.items():
    if cnt > max_count:
        max_count = cnt
        result = c
    elif cnt == max_count:
        result = '?'

print(result.upper())