import math

a = list(map(int, input().split()))
b = list(map(int, input().split()))

n = a[0] * b[1] + a[1] * b[0]
d = a[1] * b[1]

g = math.gcd(n, d)
print(n // g, d // g)