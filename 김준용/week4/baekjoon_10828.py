import sys

num = sys.stdin.read().splitlines()

del num[0]
command_to_key={"push":0,"pop":1,"size":2,"empty":3,"top":4}
stack=[]
for i in num:
    commandwV = i.split()
    command=command_to_key[commandwV[0]]
    if command == 0:
        stack.append(int(commandwV[1]))
    elif command == 1:
        if len(stack) > 0:
            print(stack.pop())
        else:
            print(-1)
    elif command == 2:
        print(len(stack))
    elif command == 3:
        if len(stack):
            print(0)
        else:
            print(1)
    else:
        if len(stack)>0:
            print(stack[-1])
        else:
            print(-1)