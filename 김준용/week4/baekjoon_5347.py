from math import prod
import sys
num = sys.stdin.read().splitlines()

i=2

del num[0]

for i in num:
    target, target2 = map(int, i.split())
    
    list1 = []
    list2 = []
    j=2
    while j*j <= target:
        placeholder = target//j
        if not target-placeholder*j:
            target = placeholder
            list1.append(j)
        else:
            j+=1
    if target>1:
        list1.append(target)    
    
    j=2
    while j*j <= target2:
        placeholder = target2//j
        if not target2-placeholder*j:
            target2 = placeholder
            list2.append(j)
        else:
            j+=1
    if target2>1:
        list2.append(target2)
    
    for i in list1:
        if i in list2:
            list2.remove(i)
    list1.extend(list2)
    print(prod(list1))