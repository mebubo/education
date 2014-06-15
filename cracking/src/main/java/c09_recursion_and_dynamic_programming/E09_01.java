package c09_recursion_and_dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class E09_01 {

    public static int countWaysToSkipSteps(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return countWaysToSkipStepsHelper(n, cache);
    }

    private static int countWaysToSkipStepsHelper(int n, Map<Integer, Integer> cache) {
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        int result = 0;
        if (n == 0) {
            result = 1;
        } else if (n > 0) {
            result = countWaysToSkipStepsHelper(n - 1, cache) + countWaysToSkipStepsHelper(n - 2, cache) + countWaysToSkipStepsHelper(n - 3, cache);
        }
        cache.put(n, result);
        return result;
    }
}
