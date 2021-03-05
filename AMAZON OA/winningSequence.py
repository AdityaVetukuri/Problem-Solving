import math
def winning_sequence(size,lower,upper):
    n = upper - lower + 1
    list = []
    if(not (n*2>size)):
        return
    mid = math.ceil((upper + lower) /2)
    dummy = mid
    while(mid <= upper and len(list) < size):
        list.append(mid)
        mid+=1
    while(upper >= lower and len(list) < size):
        list.append(upper-1)
        upper -= 1
    print(list)
size = 5
lower = 1
upper = 3
winning_sequence(size,lower,upper)