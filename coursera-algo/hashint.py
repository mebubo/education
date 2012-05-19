f = open("HashInt.txt")

d = dict([(int(i.strip()), None) for i in f.readlines()])

f.close()

sums = [231552, 234756, 596873, 648219, 726312, 981237, 988331, 1277361, 1283379]

def sums_up(d, s):
    for k in d:
        if (s-k) in d:
            return "1"
    return "0"

print "".join([sums_up(d, s) for s in sums])
