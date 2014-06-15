package c09_recursion_and_dynamic_programming;

import java.util.*;

public class E09_08 {
    public static Set<List<Integer>> change(int total, List<Integer> coins) {
        if (total == 0) {
            return new HashSet<>(Arrays.asList(Arrays.<Integer>asList()));
        }
        Set<List<Integer>> result = new HashSet<>();
        if (coins.isEmpty()) {
            return result;
        }
        int coin = coins.get(0);
        List<Integer> remainder = new ArrayList<>(coins.subList(1, coins.size()));
        for (int count = 0; count * coin <= total; count++) {
            for (List<Integer> subresult : change(total - count * coin, remainder)) {
                List<Integer> subresultCopy = new ArrayList<>(subresult);
                for (int i = 0; i < count; i++) {
                    subresultCopy.add(coin);
                }
                result.add(subresultCopy);
            }
        }
        return result;
    }

}
