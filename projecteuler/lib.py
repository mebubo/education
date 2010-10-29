from time import time

def eu_format(value, prec=6):
    return "%%.%df" % prec % round(value, prec)

def output_timed(fn, prec=6):
    start = time()
    value = fn()
    duration = time() - start
    print "%s (%.3f seconds)" % (eu_format(value), duration)

def timeit(f):
    import time
    cur = time.time()
    for i in range(100):
        f()
    return time.time() - cur
