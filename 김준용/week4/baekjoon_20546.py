import sys
num = tuple(map(int, sys.stdin.read().split()))
a_ballance = num[0]
b_ballance = num[0]
final = num[-1]
a_stock=0
b_stock=0
b_in_a_row=0
direction=0
prev=num[1]

for i in num[1:]:
    if a_ballance:
        bought=a_ballance//i
        a_stock+=bought
        a_ballance-=bought*i
    
    if i < prev:
        if not direction:
            direction=1
            b_in_a_row=0
        b_in_a_row+=1
        if b_in_a_row > 2:
            bought=b_ballance//i
            b_stock+=bought
            b_ballance-=bought*i
    elif i > prev:
        if direction:
            direction=0
            b_in_a_row=0
        b_in_a_row+=1
        if b_in_a_row > 2:
            b_ballance += b_stock*i
            b_stock=0
    else:
        b_in_a_row=0
    prev=i

a_ballance += a_stock*final
b_ballance += b_stock*final

if a_ballance > b_ballance:
    print("BNP")
elif a_ballance < b_ballance:
    print("TIMING")
else:
    print("SAMESAME")