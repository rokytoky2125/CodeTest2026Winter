import sys
filed = sys.stdin.read().split()

del filed[0]
weight_height_collection = [(int(filed[i]), int(filed[i+1])) for i in range(0,len(filed),2)]
how_many_above = [1 for i in range(len(weight_height_collection))]

i=0
for weight, height in weight_height_collection:
    for c_weight, c_height in weight_height_collection:
        if weight < c_weight and height < c_height:
            how_many_above[i] += 1
    i+=1

print(*how_many_above)
