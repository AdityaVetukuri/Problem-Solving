from queue import PriorityQueue
def loadTheCargo(num, containers, itemSize, itemsPerContainer, cargoSize):
    q = PriorityQueue()
    for x,item in enumerate(containers):
        for i in range(item):
            q.put((-itemsPerContainer[x],itemsPerContainer[x]))
    sum = 0
    while(cargoSize!=0 and q.empty() == False):
        sum += q.get()[1]
        cargoSize -= 1
    return sum
num = 3
containers = [1,2,3]
itemSize = 3
itemsPerContainer = [3,2,1]
cargoSize = 3
sum = loadTheCargo(num,containers,itemSize,itemsPerContainer,cargoSize)
