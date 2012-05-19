from numpy import *
import random
from lib import eu_format

def _filter(choices, rows, cols):
    return [(i, j) for (i, j) in choices if i not in (-1, rows) and j not in (-1, cols)]

def apply_mul(func, arg, mul):
    for k in range(mul):
        arg = func(arg)
    return arg

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

def e213(n=30, p=50):
    c = connectivity(n)
    r = apply_mul(lambda x: dot(c, x), c, p-1)
    o = ones((n**2, n**2))
    m = o-r
    return sum([prod(r) for r in m])

if __name__=="__main__":
    print eu_format(e213())
