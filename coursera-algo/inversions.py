f = open("IntegerArray.txt")

a = [int(i.strip()) for i in f.readlines()]

f.close()

def num_inv(a):
    if len(a) == 1:
        return a, 0
    div = int(len(a)/2.)
    l, nl = num_inv(a[:div])
    r, nr = num_inv(a[div:])
    i = j = cum = 0
    res = []
    for k in range(len(a)):
        if (i != len(l) and j != len(r) and l[i] <= r[j]) or j == len(r):
            res.append(l[i])
            i += 1
        else:
            res.append(r[j])
            j += 1
            cum += len(l) - i
    return res, nl + nr + cum


