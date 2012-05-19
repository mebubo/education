import random

class Graph(object):
    def __init__(self, g=None):
        if g:
            self.v = g.v.copy()
            self.rv = g.rv.copy()
            self.e = g.e.copy()
        else:
            self.v = {}
            self.rv = {}
            self.e = {}

    def add(self, r):
        tail = r[0]
        heads = r[1:]
        self.v[tail] = set(heads)
        for h in heads:
            self.add_new_edge(tail, h)
            self.rv.setdefault(h, set()).add(tail)

    def add_edge(self, t, h, count=1):
        if t > h:
            t, h = h, t
        self.e[(t, h)] = count + self.e.get((t, h), 0)

    def add_new_edge(self, t, h):
        if t > h:
            t, h = h, t
        self.e[(t, h)] = 1

    def contract(self, t, h):
        ne = []
        topop = []
        if t > h:
            t, h = h, t
        self.e.pop((t, h))
        for t1, h1 in self.e:
            if t1 == h:
                ne.append((t, h1, self.e.get((t1, h1))))
                topop.append((t1, h1))
            elif h1 == h:
                ne.append((t1, t, self.e.get((t1, h1))))
                topop.append((t1, h1))
        for e in topop:
            self.e.pop(e)
        for e in ne:
            self.add_edge(*e)

    def rand_contract(self):
        while len(self.e) > 1:
            self.contract(*random.choice(self.e.keys()))

f = open("kargerAdj.txt")

go = Graph()

for r in f.readlines():
    go.add([int(s.strip()) for s in r.split()])

f.close()


res = 1000

for i in range(40*40):
    g = Graph(go)
    g.rand_contract()
    cr = g.e.values()[0]
    if cr < res:
        res = cr
        print res

