package c01_arrays_and_strings;

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

//    public static boolean isPermutation2(String s1, String s2) {
//        return new MultiSet(s1.toCharArray()).equals(new MultiSet(s2.toCharArray()));
//    }
}
