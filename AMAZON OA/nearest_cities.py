def binary_search_recursive(array, element, start, end):
    if start > end:
        return -1

    mid = (start + end) // 2
    if element == array[mid]:
        return mid

    if element < array[mid]:
        return binary_search_recursive(array, element, start, mid-1)
    else:
        return binary_search_recursive(array, element, mid+1, end)

def nearest_cities(numOfPoints, points, xCoordinates,yCoordinates,numOfQueriedPoints,queriesPoints):
    if(len(points) == 0):
        return []
    d = {}
    for x,point in enumerate(points):
        d[point] = (xCoordinates[x],yCoordinates[x])
    for x,point in enumerate(queriesPoints):
        res = binary_search_recursive(xCoordinatesl)



num_points = 5
points = ["p1","p2","p3","p4","p5"]
xCoordinates = [10,20,30,40,50]
yCoordinates = [10,20,30,40,50]
num_queries = 5
queriedPoints = ["p1","p2","p3","p4","p5"]
nearest_cities(num_points,points,xCoordinates,yCoordinates,num_queries,queriedPoints)