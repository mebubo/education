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

import itertools

def logic_puzzle():
    "Return a list of the names of the people, in the order they arrive."
    days = (Monday, Tuesday, Wednesday, Thursday, Friday) = range(1, 6)
    orderings = list(itertools.permutations(days))
    ans = next(((Hamming, 'Hamming'), (Knuth, 'Knuth'), (Minsky, 'Minsky'), (Simon, 'Simon'), (Wilkes, 'Wilkes'))
               for Hamming, Knuth, Minsky, Simon, Wilkes in orderings
               for laptop, droid, tablet, iphone, _ in orderings
               for programmer, writer, manager, designer, _ in orderings
               if Wednesday is laptop
               if programmer != Wilkes
               if ((programmer, droid) == (Wilkes, Hamming)) or ((programmer, droid) == (Hamming, Wilkes))
               if writer != Minsky
               if manager not in (Knuth, tablet)
               if Knuth == Simon + 1
               if designer != Thursday
               if tablet != Friday
               if designer != droid
               if Knuth == manager + 1
               if ((laptop, Wilkes) == (Monday, writer)) or ((laptop, Wilkes) == (writer, Monday))
               if Tuesday in (iphone, tablet))
    return [name for i, name in sorted(ans)]
