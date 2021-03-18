
def minimumContainerSize(items, days):
    n = len(items)
    if(len(items) == 0):
        return 0
    if(len(items) == 1):
        return items[0]
    maximum_window = n - days + 1
    ptr1 = 0
    ptr2 = maximum_window
    sum = 0

    for i in range(0,maximum_window):
        sum += items[i]
    maximum_sum = sum
    max = 0
    for i in range(0,len(items) -1):
        if ptr2 >= len(items) or ptr1 >=len(items):
            break
        maximum_sum = maximum_sum + items[ptr2] - items[ptr1]
        ptr2 += 1
        ptr1 += 1
        if(maximum_sum > max):
            max = maximum_sum
            initial = ptr1
            end = ptr2
    sum = 0
    max_element = 0
    for i in range(0,len(items)):
        if(i >= initial and i<=end):
            if(items[i] > max_element):
                max_element = items[i]
        if i < initial:
            sum += items[i]
        else:
            if i >= end:
                sum += items[i]
    print(max_element + sum)

items = [10,2,20,5,15,10,1]
days = 5
minimumContainerSize(items,days)