package c09_recursion_and_dynamic_programming.e09_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution1 {
    public static Solution buildStack(List<Box> boxes) {
        return buildStackHelper(Collections.emptyList(), boxes)
                .map(Solution::new)
                .max(Comparator.comparing(Solution::getHeight)).get();
    }

    static Stream<List<Box>> buildStackHelper(List<Box> partialSolution, List<Box> boxes) {
        if (boxes.isEmpty() ||
                IntStream.range(0, boxes.size())
                        .noneMatch(i -> allowed(boxes.get(i), partialSolution))) {
            return Stream.of(partialSolution);
        }
        return IntStream.range(0, boxes.size())
                .filter(i -> allowed(boxes.get(i), partialSolution))
                .mapToObj(Integer::valueOf)
                .flatMap(i -> buildStackHelper(append(partialSolution, boxes.get(i)), remove(boxes, i, partialSolution)));
    }

    private static List<Box> remove(List<Box> boxes, int i, List<Box> partialSolution) {
        ArrayList<Box> result = new ArrayList<Box>(boxes);
        result.remove(i);
        return result.stream().filter(b -> allowed(b, partialSolution)).collect(Collectors.toList());
    }

    private static List<Box> append(List<Box> partialSolution, Box box) {
        ArrayList<Box> result = new ArrayList<Box>(partialSolution);
        result.add(box);
        return result;
    }

    private static boolean allowed(Box box, List<Box> partialSolution) {
        if (partialSolution.isEmpty()) {
            return true;
        }
        Box top = partialSolution.get(partialSolution.size() - 1);
        return top.compareTo(box) > 0;
    }

}
