import sys

heights = sorted(map(int, sys.stdin.read().split()), reverse=True)
overflow = sum(heights)-100
pos=0
for i in heights:
    pos+=1
    temp = overflow - i
    for j in heights[pos:]:
        if (j == temp):
            del heights[pos-1]
            heights.remove(j)
            heights.reverse()
            [print(k) for k in heights]
            sys.exit()

    
