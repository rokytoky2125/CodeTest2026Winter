given_value = 10
que = []
while (given_value != -1):
    given_value = int(input())
    que.append(given_value)
del que[-1]

def check_if_perfect(value):
    que = []
    sum = 0
    upper_range = int(value/2)
    for i in range(1,upper_range+1):
        if not value%i:
            que.append(i)
            sum+=i
            #make code the checks if you are already too big
            if sum > value:
                print(f"{value} is NOT perfect.")
                return 0
    if sum < value:
        print(f"{value} is NOT perfect.")
        return 0
    else:
        print(f"{value} = {que[0]}", end='')
        for i in que[1:]:
            print(f" + {i}", end='')
        print()
        return 0

for check_dis in que:
    check_if_perfect(check_dis)
