import sys
filed = sys.stdin.read().splitlines()

row, column = filed[0].split()
for i in range(int(row)):
    out = []
    clouds = [i for i in filed[i+1]]
    if clouds[-1] == 'c':
        last_cloud = True
    else:
        last_cloud = False
    prev_cloud = 0
    wellshit = False
    if last_cloud:
        for j in clouds[:-1]:
            prev_cloud+=1
            if j == 'c':
                wellshit=True
                prev_cloud = 0
                out.append(0)
            elif wellshit:
                out.append(prev_cloud)
            else:
                out.append(-1)
        out.append(0)
    else:
        for j in clouds:
            prev_cloud+=1
            if j == 'c':
                wellshit=True
                prev_cloud = 0
                out.append(0)
            elif wellshit:
                out.append(prev_cloud)
            else:
                out.append(-1)
    print(*out)
    