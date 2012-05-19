f = open("QuickSort.txt")

a = [int(i.strip()) for i in f.readlines()]

f.close()

c = 0

def quicksort(x, reset=False):
    global c
    if reset:
        c = 0
    N = len(x)
    if N <= 1:
        return x
    pi = pivot(x)
    swap(x, 0, pi)
    p = x[0]
    i = 0
    for j in range(1, N):
        if x[j] < p:
            i += 1
            swap(x, j, i)
        #print c
        c += 1
    swap(x, 0, i)
    #c += (i-1) + (N-(i+1)-1)
    r = quicksort(x[:i]) + [p] + quicksort(x[i+1:])
    if reset:
        return r, c
    return r

def swap(x, i, j):
    #print x, i, j
    x[i], x[j] = x[j], x[i]

def pivot(x):
    #return 0
    #return -1
    return sorted([(x[0], 0), (x[(len(x)-1)/2], (len(x)-1)/2) , (x[-1], -1)])[1][1]
