package c09_recursion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E09_09 {
    public static List<List<Integer>> queens(int n) {
        return queensHelper(n, n - 1).collect(Collectors.toList());
    }

    static Stream<List<Integer>> queensHelper(int n, int i) {
        if (i == 0) {
            return IntStream.range(0, n).mapToObj(Collections::singletonList);
        }
        return queensHelper(n, i - 1)
                .flatMap(partialSolution ->
                        IntStream.range(0, n)
                                .filter(k -> allowed(k, partialSolution))
                                .mapToObj(k -> prepend(k, partialSolution)));
    }

    private static List<Integer> prepend(final int k, final List<Integer> solution) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(k);
        result.addAll(solution);
        return result;
    }

    private static boolean allowed(int k, List<Integer> solution) {
        return IntStream.range(0, solution.size())
                .allMatch(i -> solution.get(i) != k && solution.get(i) != k + 1 + i && solution.get(i) != k - 1 - i);
    }

    static List<List<Integer>> queensHelper0(int n, int i) {
        if (i == 0) {
            return IntStream.range(0, n).mapToObj(Collections::singletonList).collect(Collectors.toList());
        }
        List<List<Integer>> subSolutions = queensHelper0(n, i - 1);
        Function<List<Integer>, Stream<List<Integer>>> extendSolution = solution ->
                IntStream.range(0, n).filter(k -> allowed(k, solution))
                        .mapToObj(k -> prepend(k, solution));
        return subSolutions.stream().flatMap(extendSolution).collect(Collectors.toList());
    }

}
