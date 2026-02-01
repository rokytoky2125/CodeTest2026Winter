a, b = map(int, input().split())
a_lst = list(map(int, input().split()))
b_lst = list(map(int, input().split()))

a_only = set(a_lst) - set(b_lst)
b_only = set(b_lst) - set(a_lst)

print(len(a_only) + len(b_only))