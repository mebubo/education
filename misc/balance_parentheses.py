#!/usr/bin/env python

def balance_parentheses(chars):
    def increment(char):
        if char == "(": return 1
        if char == ")": return -1
        return 0
    values = [increment(char) for char in chars]
    print values
    return all(map(lambda x: x >= 0, values)) and values and values[-1] == 0
