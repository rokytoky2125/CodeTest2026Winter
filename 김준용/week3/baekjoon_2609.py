a, b = map(int, input().split())

def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a%b)

c = gcd(a,b)
print(c)
print((a*b)//c)
