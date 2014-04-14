package c01_arrays_and_strings;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Chars;

import java.util.Map;
import java.util.HashMap;

public class E01_03 {
    private static Map<Character, Integer> characterCounts(String s) {
        Map<Character, Integer> result = new java.util.HashMap<>();
        for (char c : s.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }

    public static boolean isPermutation(String s1, String s2) {
        return characterCounts(s1).equals(characterCounts(s2));
    }

    public static boolean isPermutation2(String s1, String s2) {
        return toMultiset(s1).equals(toMultiset(s2));
    }

    private static Multiset<Character> toMultiset(String s1) {
        return HashMultiset.create(Chars.asList(s1.toCharArray()));
    }
}
