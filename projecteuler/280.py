from numpy import *
import random
from lib import eu_format

class memoize:
    def __init__(self, function):
        self.function = function
        self.memoized = {}

    def __call__(self, *args):
        try:
            return self.memoized[args]
        except KeyError:
            self.memoized[args] = self.function(*args)
        return self.memoized[args]

def _filter(choices, rows, cols):
    return [(i, j) for (i, j) in choices if i not in (-1, rows) and j not in (-1, cols)]

def connectivity(n):
    dim = n*n
    M = zeros((dim,dim))
    for i in range(n):
        for j in range(n):
            choices = ((i-1, j), (i+1, j), (i, j-1), (i,j+1))
            choices = _filter(choices, n, n)
            prob = 1.0/len(choices)
            for c in choices:
                M[c[0]*n+c[1], i*n+j] += prob
    return M

@memoize
def ex(st=0, fi=0, excl=(0,0,0,0,0)):
    c = connectivity(5)
    c[:,fi] = 0
    for i, e in enumerate(excl):
        if e != 0:
            c[:,i] = 0
    s = zeros(25)
    s[20+st] = 1
    _sum = 0
    prob = 0
    for i in range(1, 2000):
        s = dot(c,s)
        cur = s[fi]
        _sum += cur*i
        prob += cur
        if i > 100 and 0<abs(cur)<10e-14:
            break
    return prob, _sum

def f(st=-8, top=(0,0,0,0,0), bot=(1,1,1,1,1), carry=False, rec=0):
    r = 0
    rec += 1
    if carry:
        excl = tuple(1-array(top))
        bot_new = list(bot)
        bot_new[st] = 0
        bot_new = tuple(bot_new)
        for i, e in enumerate(excl):
            if e==1:
                top_new = list(top)
                top_new[i] = 1
                top_new = tuple(top_new)
                p, s = ex(st, i, excl)
                r += s + p * (f(i, top_new, bot_new, False, rec))
    else:
        excl = bot
        for i, e in enumerate(excl):
            if e==1:
                p, s = ex(st, i, excl)
                r += s + p * (f(i, top, bot, True, rec))
    #print "-"*rec + ">", st, top, bot, carry, r
    return r

if __name__=="__main__":
    ret = eu_format(f())
    print ret
    assert ret=="430.088247"

