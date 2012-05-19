import sys, random
from collections import defaultdict
#sys.setrecursionlimit(100000)

# 359032 -- wrong

def read():

    f = open("SCC.txt")
    
    g = defaultdict(list)
    gr = defaultdict(list)

    r = f.readline()
    while r:
        t, h = map(int, r.split())
        g[t].append(h)
        gr[h].append(t)
        r = f.readline()

    f.close()

    return g, gr

def dfs_loop(g, order=None):
    explored = [False]*(max(g.keys())*2)
    finish = []
    count = 0
    if order is None:
        order = g.keys()
        random.shuffle(order)
    for v in order:
        if not explored[v]:
            #print "==== calling dfs"
            dfs(g, v, explored, finish)
            count += 1
    print "dfs invoked %d times" % count
    return finish

def dfs2(g, v, explored, finish):
    explored[v] = True
    for c in g[v]:
        if not explored[c]:
            dfs(g, c, explored, finish)
    finish.append(v)

def dfs(g, v, explored, finish):
    explored[v] = True
    current = [v]

    #count = 0

    while current:

        new_children = [c for c in g[current[-1]] if not explored[c]]

        if not new_children:
            finish.append(current.pop())
        else:
            for c in new_children:
                explored[c] = True
            current.extend(new_children)

        #count += 1
        #if (count%1000) == 0:
        #    print count, len(current), len(finish)
