import sys
EQ = tuple(map(int, input().split()))
output = sys.stdout.write

adjoint = EQ[0]*EQ[4]-EQ[1]*EQ[3]
x = (EQ[2]*EQ[4]-EQ[5]*EQ[1])/adjoint
y = (EQ[0]*EQ[5]-EQ[2]*EQ[3])/adjoint
#Linear algebra freaking clutches this! Cramer's rule for the WIN!
output("%d %d" % (x, y))