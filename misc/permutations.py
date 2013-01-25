def perm(s):
    if len(s) == 1:
        return [s]
    return [c + p for (i, c) in enumerate(s) for p in perm(s[:i] + s[i+1:])]

def perm2(s):
    def loop(remaining, current):
        print remaining
        if len(current) == len(s):
            return [current]
        else:
            res = []
            for i, c in enumerate(remaining):
                res.extend(loop(remaining[:i] + remaining[i+1:], current + c))
        return res
    return loop(s, "")
