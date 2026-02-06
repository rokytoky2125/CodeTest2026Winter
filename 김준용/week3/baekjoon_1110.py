number = input()
if int(number) > 9:
    left, right = [int(i) for i in number]
else:
    left = 0
    right = int(number)
Nleft = right
Nright = left+right
if Nright > 9:
    Nright = [int(i) for i in str(Nright)][1]
counter = 1
while True:
    if (Nleft == left) and (Nright == right):
        break
    counter+=1
    temp = Nright
    Nright += Nleft
    Nleft = temp
    if Nright > 9:
        Nright = [int(i) for i in str(Nright)][1]
print(counter)