X, W, Y, L = map(int, input().split())
if X > L:
    print(0)
    raise SystemExit
f = 0
c = 0
for _ in range(24):
    if f + X <= L:
        f += X
        c += W
    else:
        f -= Y
        if f < 0:
            f = 0
print(c)