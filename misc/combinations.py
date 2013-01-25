#!/usr/bin/env python


def combinations(p, r):
    print p, r
    if r == 1:
        return [[e] for e in p]
    if len(p) < r:
        return []
    else:
        return [([p[0]] + t) for t in combinations(p[1:], r-1)] + combinations(p[1:], r)

def combinations_with_rep(l, k):
    if k == 1:
        for e in l:
            yield [e]
        return
    if len(l) == 0:
        return
    for comb in combinations_with_rep(l, k-1):
        yield comb + [l[0]]
    for comb in combinations_with_rep(l[1:], k):
        yield comb

def combinations2(iterable, r):
    # combinations('ABCD', 2) --> AB AC AD BC BD CD
    # combinations(range(4), 3) --> 012 013 023 123
    pool = tuple(iterable)
    n = len(pool)
    if r > n:
        return
    indices = range(r)
    yield tuple(pool[i] for i in indices)
    while True:
        for i in reversed(range(r)):
            print "^^^", i, indices[i], i + n - r
            if indices[i] != i + n - r:
                break
        else:
            return
        indices[i] += 1
        for j in range(i+1, r):
            print "***", j
            indices[j] = indices[j-1] + 1
        print "===", i, indices
        yield tuple(pool[i] for i in indices)
