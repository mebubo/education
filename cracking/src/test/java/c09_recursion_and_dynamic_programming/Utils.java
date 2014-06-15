package c09_recursion_and_dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;

public class Utils {
    public static char[][] mapToCharArray(String[] map) {
        int height = map.length;
        int width = map[0].length();
        char[][] result = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = map[i].charAt(j);
            }
        }
        return result;
    }

    static <T> HashSet<T> getSet(T... array) {
        return new HashSet<T>(Arrays.asList(array));
    }
}
