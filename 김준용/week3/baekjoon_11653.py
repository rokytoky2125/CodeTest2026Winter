#combine a factor finder and divider
#Logic: divide by the values currently in factor list.
#If factor list is exhausted, but the value is not 1: create new factors that work
#if the value is one, end program O


to_be_seperated = int(input())
i=2
while i*i<=to_be_seperated:
    placeholder = to_be_seperated//i
    if not to_be_seperated-placeholder*i:
        to_be_seperated = placeholder
        print(i)
    else:
        i+=1
if to_be_seperated>1:
    print(to_be_seperated)