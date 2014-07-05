package c09_recursion_and_dynamic_programming.e09_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution2 {


    public static Solution buildStack2(List<Box> boxes) {
        return buildStackHelper2(null, boxes)
                .map(Solution::new)
                .max(Comparator.comparing(Solution::getHeight)).get();
    }

    static Stream<List<Box>> buildStackHelper2(Box bottom, List<Box> boxes) {
        System.out.println("bottom = [" + bottom + "], boxes = [" + boxes + "]");
        if (boxes.isEmpty() ||
                IntStream.range(0, boxes.size())
                        .noneMatch(i -> allowed2(boxes.get(i), bottom))) {
            return Stream.of(Collections.<Box>emptyList());
        }
        return IntStream.range(0, boxes.size())
                .filter(i -> allowed2(boxes.get(i), bottom))
                .mapToObj(Integer::valueOf)
                .flatMap(i -> buildStackHelper2(boxes.get(i), boxes)
                        .map(list -> prepend(boxes.get(i), list)));
    }

    private static List<Box> prepend(Box box, List<Box> list) {
        ArrayList<Box> result = new ArrayList<>();
        result.add(box);
        result.addAll(list);
        return result;
    }


    private static boolean allowed2(Box box, Box bottom) {
        return bottom == null || bottom.compareTo(box) > 0;
    }

    private static List<Box> remove2(List<Box> boxes, int i) {
        ArrayList<Box> result = new ArrayList<Box>(boxes);
        result.remove(i);
        return result;
    }

}
