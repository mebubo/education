package c09_recursion_and_dynamic_programming;

import c09_recursion_and_dynamic_programming.e09_10.Solution1;
import c09_recursion_and_dynamic_programming.e09_10.Solution2;
import c09_recursion_and_dynamic_programming.e09_10.Solution;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import c09_recursion_and_dynamic_programming.e09_10.Box;
import static org.junit.Assert.*;

public class E09_10Test {

    @Test
    public void testAllImpls() {
        Stream.<Function<List<Box>, Solution>>of(Solution1::buildStack, Solution2::buildStack2)
                .forEach(this::testBuildStack);
    }


    public void testBuildStack(Function<List<Box>, Solution> impl) {
        assertEquals(2, impl.apply(Arrays.asList(new Box(1, 2, 3))).getHeight());
        assertEquals(5, impl.apply(Arrays.asList(new Box(1, 2, 3), new Box(2, 3, 4))).getHeight());
        assertEquals(8, impl.apply(getBoxes8()).getHeight());
        assertEquals(100, impl.apply(getBoxes100()).getHeight());
    }

    private List<Box> getBoxes8() {
        return Arrays.asList(new Box(4, 4, 4), new Box(100, 1, 100), new Box(3, 3, 3), new Box(3, 2, 3), new Box(1, 1, 1));
    }

    private List<Box> getBoxes100() {
        return Arrays.asList(new Box(4, 4, 4), new Box(100, 100, 1), new Box(3, 3, 3), new Box(3, 2, 3), new Box(1, 1, 1));
    }
}