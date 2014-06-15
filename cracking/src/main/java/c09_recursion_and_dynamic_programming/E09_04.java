package c09_recursion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class E09_04 {
    public static <T> Set<Set<T>> subsets(Set<T> set) {
        if (set.isEmpty()) {
            return new HashSet<>(Arrays.asList(new HashSet<T>()));
        }
        Iterator<T> iterator = set.iterator();
        T e = iterator.next();
        iterator.remove();
        Set<Set<T>> result = subsets(set);
        Set<Set<T>> including = new HashSet<>();
        for (Set<T> ts : result) {
            HashSet<T> copy = new HashSet<>(ts);
            copy.add(e);
            including.add(copy);
        }
        result.addAll(including);
        return result;
    }

}
