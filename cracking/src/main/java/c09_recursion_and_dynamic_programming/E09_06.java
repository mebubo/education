package c09_recursion_and_dynamic_programming;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class E09_06 {
    public static Set<String> parentheses(int n) {
        return parenthesesHelper(n, n);
    }

    private static Set<String> parenthesesHelper(int opening, int closing) {
        if (opening == 0 && closing == 0) {
            return new HashSet<>(Arrays.asList(""));
        }
        HashSet<String> result = new HashSet<>();
        if (opening > 0) {
            result.addAll(prepend("(", parenthesesHelper(opening - 1, closing)));
        }
        if (closing > opening) {
            result.addAll(prepend(")", parenthesesHelper(opening, closing - 1)));
        }
        return result;
    }

    private static Collection<String> prepend(String s, Set<String> set) {
        return set.stream().map(string -> s + string).collect(Collectors.toList());
    }

}
