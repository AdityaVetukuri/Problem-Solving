def countLRU(num , pages, cacheSize):
    if(num == 0):
        return 0
    cache = []
    cacheMap = dict()
    cache_miss = 0
    lru = pages[0]
    for page in pages:
        if page in cache:
            cache.remove(page)
        else:
            cache_miss +=1
            if(len(cache) < cacheSize):
                cache.append(page)
                lru = page
            else:
                cache.pop()
                cache.append(page)
                lru = page
    return cache_miss

num = 10
pages = [8, 3, 6, 2, 8, 8, 2, 6, 6, 7]
cacheSize = 2
cache_miss = countLRU(num, pages, cacheSize)
print(cache_miss)