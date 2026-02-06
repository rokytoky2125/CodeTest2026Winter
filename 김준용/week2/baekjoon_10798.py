string_collection=[]
string_length_collection=[]
biggest_length=0
for i in range(5):
    string = input()
    str_len = len(string)
    string_collection.append(string)
    string_length_collection.append(str_len)

    if str_len > biggest_length:
        biggest_length = str_len

for i in range(biggest_length):
    for l in range(5):
        if i < string_length_collection[l]:
            print(string_collection[l][i], end='')
