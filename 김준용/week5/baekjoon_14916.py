change = int(input())
change_count=0
if change==1 or change == 3:
    print(-1)
else:
    while change%5:
        change-=2
        change_count+=1
    change_5=change//5
    change_count+= change_5
    change-=change_5*5
    if change:
        print(-1)
    else:
        print(change_count)
    
