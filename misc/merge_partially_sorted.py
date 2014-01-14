#!/usr/bin/env python

import heapq

def mergeFiles(f1, f2, outfile, maxDisplacement):
    writeFile(merge(sort(iterateOverLines(f1), maxDisplacement),
sort(iterateOverLines(f2), maxDisplacement)), outfile)

def writeFile(iter, outfile):
    with open(outfile, "w") as f:
        for line in iter:
            f.write(line)

def iterateOverLines(inputfile):
    with open(inputfile, "r") as f:
        for line in f:
            yield line

def sort(it, maxDisplacement):
    buffer = []
    for i in it:
        if len(buffer) < maxDisplacement:
            heapq.heappush(buffer, i)
            continue
        yield heapq.heappushpop(buffer, i)
    while len(buffer) > 0:
        yield heapq.heappop(buffer)

def merge(it1, it2):
    next1 = next(it1, None)
    next2 = next(it2, None)
    while next1 is not None or next2 is not None:
        if next1 is not None and next2 is not None:
            if next1 < next2:
                yield next1
                next1 = next(it1, None)
            else:
                yield next2
                next2 = next(it2, None)
        elif next1 is not None:
            yield next1
            next1 = next(it1, None)
        elif next2 is not None:
            yield next2
            next2 = next(it2, None)

if __name__ == "__main__":
    mergeFiles("a.txt", "b.txt", "/dev/stdout", 40)
