end, nth = input().split()
nth = int(nth)
value_list = list(range(2,int(end)+1))
while nth:
    smallest_val=value_list[0]
    length= len(value_list)
    i=0
    while i < length:
        some_val = value_list[i]
        if not some_val % smallest_val:
            nth-=1
            if not nth:
                print(some_val)
                break
            length-=1
            del value_list[i]
        else:
            i+=1

