from queue import PriorityQueue

def countLevelUpPlayers(cutOffRank, num , scores):
    q = PriorityQueue()
    for score in scores:
        if(score!=0):
            q.put((-score,score))
    list = []
    rank = 0
    temp_rank = 0
    temp = -1
    while(q.empty()==False):
        val = q.get()[1]
        if(val != temp):
            temp = val
            rank += 1
            list.append(rank)
        else:
            list.append(rank)
    start = list[0]
    count = 0
    for x,rank in enumerate(list):
        count+=1
        if(rank !=start):
            list[x] = count
            start = rank
        else:
            if(x!=0):
                list[x] = list[x-1]
    count = 0
    for rank in list:
        if(rank <= cutOffRank):
            count +=1
    return count
cutOffRank = 5
num = 5
scores = [1,0,1,0,1,0,2,0,2,3,0,1,3,3,4,4,4,4]
result = countLevelUpPlayers(cutOffRank, num, scores)
print(result)