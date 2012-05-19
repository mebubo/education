from numpy import *
import random

def step(M):
    rows, cols = M.shape
    M2 = zeros(M.shape)
    for i, row in enumerate(M):
        for j, col in enumerate(row):
            for k in range(int(col)):
                choices = ((i-1, j), (i+1, j), (i, j-1), (i,j+1))
                choices = _filter(choices, rows, cols)
                choice = random.choice(choices)
                M2[choice] += 1
    assert sum(M2) == sum(M)
    return M2

def _filter(choices, rows, cols):
    return [(i, j) for (i, j) in choices if i not in (-1, rows) and j not in (-1, cols)]

def num_zeros(M):
    return len([a for a in M.flatten() if a == 0])

def apply_mul(func, arg, mul):
    for k in range(mul):
        arg = func(arg)
    return arg

def num_zeros_after(M, steps):
    return num_zeros(apply_mul(step, M, steps))

M = ones((5,5))

def do():
    return num_zeros_after(M, 50)

def average_prec(func, prec):
    last = 0
    cur = float(func())
    _sum = cur
    count = 1
    while abs((last-cur)/cur) > prec or count < 100000:
        print count, cur
        last = cur
        count += 1
        val = func()
        _sum += val
        cur = _sum/count

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
