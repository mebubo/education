#!/usr/bin/env python

def count_change(money, coins):
    if not money:
        return 1
    if not coins:
        return 0
    return sum(count_change(money-x, coins[1:])
               for x in range(0, money+1, coins[0]))
