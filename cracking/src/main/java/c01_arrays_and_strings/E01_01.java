package c01_arrays_and_strings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class E01_01 {

    public static boolean allUnique(String str) {
        Set<Character> seen = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (seen.contains(c)) {
                return false;
            }
            seen.add(c);
        }
        return true;
    }

    public static boolean allUniqueNoAdditionalStorage(String str) {
        long bits = 0;
        for (char c : str.toCharArray()) {
            int index;
            if ('a' <= c && c <='z') {
                index = c - 'a';
            } else if ('A' <= c && c <= 'Z') {
                index = 32 + c - 'A';
            } else {
                throw new IllegalArgumentException("Only characters in a-z, A-Z are accepted");
            }
            if ((bits & (1L << index)) > 0) {
                return false;
            }
            bits |= (1L << index);
        }
        return true;
    }

}
