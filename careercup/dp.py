#!/usr/bin/env python

"http://www.careercup.com/question?id=11641125"

import sys, math

cache = {}
comb, curr = [], []

def f(n, k):
    global cache, comb, curr
    if (n, k) in cache:
        return cache[(n, k)]
    if n>0 and k==0:
        ret = 1
        comb.append(list(curr))
    elif n>=1 and k==1:
        ret = 1
        comb.append(list(curr) + [1])
    elif (n<1 or k<1) or (n==1 and k>1):
        ret = 0
    elif n>1 and k>1:
        n2 = n - 1
        curr.append(n2)
        k2 = k - n
        sum = 0
        while n2 > 0:
            curr[-1] = n2 + 1
            if k2 >= 0:
                inc = f(n2, k2)
            else:
                inc = 0
            sum += inc
            n2 -= 1
            k2 += 1
        curr.pop()
        ret = sum
    else:
        print "should not happen"
        sys.exit(1)
    cache[(n, k)] = ret
    return ret
    
#print f(500, 500)
