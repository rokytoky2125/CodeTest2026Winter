import sys
filed = sys.stdin.read().splitlines()
del filed[0]
good_words = 0

for word in filed:
    stack = []
    previous_letter = ''
    for letter in word:
        stack.append(letter)
        if letter == previous_letter:
            del stack[-1]
            del stack[-1]
        if len(stack) == 0:
            previous_letter = ''
        else:
            previous_letter = stack[-1]
    if len(stack) < 1:
        good_words += 1

print(good_words)
