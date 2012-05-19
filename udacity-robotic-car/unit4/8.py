# ----------
# User Instructions:
# 
# Define a function, search() that takes no input
# and returns a list
# in the form of [optimal path length, x, y]. For
# the grid shown below, your function should output
# [11, 4, 5].
#
# If there is no valid path from the start point
# to the goal, your function should return the string
# 'fail'
# ----------

# Grid format:
#   0 = Navigable space
#   1 = Occupied space

grid = [[0, 0, 1, 0, 0, 0],
        [0, 0, 1, 0, 1, 0],
        [0, 0, 0, 0, 1, 0],
        [0, 0, 1, 1, 1, 0],
        [0, 0, 0, 0, 1, 0]]

init = [0, 0]
goal = [len(grid)-1, len(grid[0])-1] # Make sure that the goal definition stays in the function.

dimx, dimy = [len(grid), len(grid[0])]

delta = [[-1, 0 ], # go up
        [ 0, -1], # go left
        [ 1, 0 ], # go down
        [ 0, 1 ]] # go right

delta_name = ['^', '<', 'v', '>']

cost = 1

def search():
    checked = []
    open = [[0] + init]
    def found():
        for g, x, y in open:
            if [x, y] == goal:
                return [g, x, y]
        return False
    while not found() and open:
        open.sort()
        e = open.pop(0)
        for dx, dy in delta:
            x = e[1] + dx
            y = e[2] + dy
            if 0 <= x and x <= dimx-1 and 0 <= y and y <= dimy-1 and grid[x][y] == 0 and [x, y] not in checked:
                open.append([e[0] + cost, x, y])
            checked.append([x, y])
    f = found()
    if f:
        return f
    return "fail"

print search()
