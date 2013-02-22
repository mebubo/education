import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given a list of integers, find all sublists of a given size that sum up to a
 * given value.
 * 
 */
public class SubLists {

    public static List<List<Integer>> subListsOfSum(List<Integer> list, int sum, int size) {

        calls++;
        Parameters parameters = new Parameters(list, sum, size);
        List<List<Integer>> cachedResult = cache.get(parameters);
        if (cachedResult != null) {
            return cachedResult;
        }

        List<List<Integer>> result;

        if (size == 0 && sum == 0) {
            result = Collections.<List<Integer>> singletonList(new ArrayList<Integer>());
        } else if (size < 0 || sum < 0 || list.size() == 0) {
            result = Collections.<List<Integer>> emptyList();
        } else {
            result = new ArrayList<List<Integer>>();
            List<Integer> tail = new ArrayList<Integer>(list);
            int head = tail.remove(0);
            // including head
            for (List<Integer> subSolution : subListsOfSum(tail, sum - head, size - 1)) {
                subSolution.add(head);
                result.add(subSolution);
            }
            // excluding head
            result.addAll(subListsOfSum(tail, sum, size));
        }

        cache.put(parameters, result);

        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(subListsOfSum(range(200), 50, 10).size());
        System.out.printf("%s %s\n", calls, cache.size());
        System.out.println(System.currentTimeMillis() - start);
    }

    private static class Parameters {
        List<Integer> list;
        int sum;
        int size;

        public Parameters(List<Integer> list, int sum, int size) {
            super();
            this.list = list;
            this.sum = sum;
            this.size = size;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((list == null) ? 0 : list.hashCode());
            result = prime * result + size;
            result = prime * result + sum;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Parameters)) {
                return false;
            }
            Parameters other = (Parameters) obj;
            if (list == null) {
                if (other.list != null) {
                    return false;
                }
            } else if (!list.equals(other.list)) {
                return false;
            }
            if (size != other.size) {
                return false;
            }
            if (sum != other.sum) {
                return false;
            }
            return true;
        }

    }

    private static Map<Parameters, List<List<Integer>>> cache = new HashMap<Parameters, List<List<Integer>>>();
    private static int calls;

    private static List<Integer> range(int max) {
        List<Integer> list = new ArrayList<Integer>(max);
        for (int i = 0; i < max; i++) {
            list.add(i);
        }
        return list;
    }
}
