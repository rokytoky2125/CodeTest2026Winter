_, commands = input().split()

default = list(map(int, input().split()))

def change_one_val(original_list, a, b):
    original_list[a-1] = b

def flipper(original_list, a, b):
    for i in range(a-1, b):
        original_list[i] = not original_list[i]

def turn_those_off(original_list, a, b):
    for i in range(a-1, b):
        original_list[i] = 0

def turn_those_on(original_list, a, b):
    for i in range(a-1, b):
        original_list[i] = 1

mapping = {1:change_one_val, 2:flipper, 3:turn_those_off, 4:turn_those_on}
for i in range(int(commands)): #match case is preferred, but I'm using python 3.9.6 so... yeah no.
    command, a, b = map(int, input().split())
    mapping[command](default, a, b)

for i in map(int, default):
    print(i, end=' ')