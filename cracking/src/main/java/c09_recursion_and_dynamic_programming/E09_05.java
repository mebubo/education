package c09_recursion_and_dynamic_programming;

import java.util.*;

public class E09_05 {
    public static Set<String> permutations(String string) {
        if (string.isEmpty()) {
            return new HashSet<>(Arrays.asList(""));
        }
        char first = string.charAt(0);
        HashSet<String> result = new HashSet<>();
        for (String permutation : permutations(string.substring(1))) {
            result.addAll(insert(first, permutation));
        }
        return result;
    }

    static Collection<String> insert(char c, String string) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i <= string.length(); i++) {
            result.add(string.substring(0, i) + c + string.substring(i, string.length()));
        }
        return result;
    }

}
