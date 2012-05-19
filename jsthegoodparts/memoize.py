#!/usr/bin/env python

def memoize(memo, formula):
    def ret(n):
        if n not in memo:
            memo[n] = formula(ret, n)
        return memo[n]
    return ret

fibonacci = memoize({0:0, 1:1}, lambda f, n: f(n-1) + f(n-2))
factorial = memoize({1:1}, lambda f, n: f(n-1) * n)

print fibonacci(10)
print factorial(10)
