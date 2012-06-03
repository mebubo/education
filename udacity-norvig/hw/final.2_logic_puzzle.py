"""
UNIT 2: Logic Puzzle

You will write code to solve the following logic puzzle:

1. The person who arrived on Wednesday bought the laptop.
2. The programmer is not Wilkes.
3. Of the programmer and the person who bought the droid,
   one is Wilkes and the other is Hamming.
4. The writer is not Minsky.
5. Neither Knuth nor the person who bought the tablet is the manager.
6. Knuth arrived the day after Simon.
7. The person who arrived on Thursday is not the designer.
8. The person who arrived on Friday didn't buy the tablet.
9. The designer didn't buy the droid.
10. Knuth arrived the day after the manager.
11. Of the person who bought the laptop and Wilkes,
    one arrived on Monday and the other is the writer.
12. Either the person who bought the iphone or the person who bought the tablet
    arrived on Tuesday.

You will write the function logic_puzzle(), which should return a list of the
names of the people in the order in which they arrive. For example, if they
happen to arrive in alphabetical order, Hamming on Monday, Knuth on Tuesday, etc.,
then you would return:

['Hamming', 'Knuth', 'Minsky', 'Simon', 'Wilkes']

(You can assume that the days mentioned are all in the same week.)
"""

# day: Monday, Tuesday, Wednesday, Thursday, Friday
# name: Hamming, Knuth, Minsky, Simon, Wilkes
# gadget: laptop, droid, tablet, iphone
# profession: programmer, writer, manager, designer

import itertools, time

def logic_puzzle_gen():
    "Return a list of the names of the people, in the order they arrive."
    days = (Monday, Tuesday, Wednesday, Thursday, Friday) = range(1, 6)
    orderings = list(itertools.permutations(days))
    ans = next(((Hamming, 'Hamming'), (Knuth, 'Knuth'), (Minsky, 'Minsky'), (Simon, 'Simon'), (Wilkes, 'Wilkes'))
               for Hamming, Knuth, Minsky, Simon, Wilkes in orderings
               if Knuth == Simon + 1
               for laptop, droid, tablet, iphone, _ in orderings
               if Tuesday in (iphone, tablet)
               if tablet != Friday
               if Wednesday is laptop
               for programmer, writer, manager, designer, _ in orderings
               if programmer != Wilkes
               if ((programmer, droid) == (Wilkes, Hamming)) or ((programmer, droid) == (Hamming, Wilkes))
               if writer != Minsky
               if manager not in (Knuth, tablet)
               if designer != Thursday
               if designer != droid
               if Knuth == manager + 1
               if ((laptop, Wilkes) == (Monday, writer)) or ((laptop, Wilkes) == (writer, Monday))
               )
    return [name for i, name in sorted(ans)]

def logic_puzzle():
    "Return a list of the names of the people, in the order they arrive."
    days = (Monday, Tuesday, Wednesday, Thursday, Friday) = range(1, 6)
    orderings = list(itertools.permutations(days))
    for Hamming, Knuth, Minsky, Simon, Wilkes in orderings:
        if Knuth == Simon + 1:
            for laptop, droid, tablet, iphone, _ in orderings:
               if (Tuesday in (iphone, tablet)) \
               and (tablet != Friday) \
               and (Wednesday is laptop):
                   for programmer, writer, manager, designer, _ in orderings:
                       if (programmer != Wilkes) \
                               and (((programmer, droid) == (Wilkes, Hamming)) or ((programmer, droid) == (Hamming, Wilkes))) \
                               and (writer != Minsky) \
                               and (manager not in (Knuth, tablet)) \
                               and (designer != Thursday) \
                               and (designer != droid) \
                               and (Knuth == (manager + 1)) \
                               and (((laptop, Wilkes) == (Monday, writer)) or ((laptop, Wilkes) == (writer, Monday))):
                           ans = ((Hamming, 'Hamming'), (Knuth, 'Knuth'), (Minsky, 'Minsky'), (Simon, 'Simon'), (Wilkes, 'Wilkes'))
                           break
    return [name for i, name in sorted(ans)]

def timedcall(fn, *args):
    "Call function with args; return the time in seconds and result."
    t0 = time.clock()
    result = fn(*args)
    t1 = time.clock()
    return t1-t0, result

print timedcall(logic_puzzle_gen)
print timedcall(logic_puzzle)
