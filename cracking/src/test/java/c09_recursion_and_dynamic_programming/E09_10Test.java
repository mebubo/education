package c09_recursion_and_dynamic_programming;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static c09_recursion_and_dynamic_programming.E09_10.buildStack;
import static org.junit.Assert.*;

public class E09_10Test {

    @Test
    public void testBuildStack() throws Exception {
        assertEquals(2, buildStack(Arrays.asList(new E09_10.Box(1, 2, 3))).getHeight());
        assertEquals(8, buildStack(getBoxes()).getHeight());
    }

    private List<E09_10.Box> getBoxes() {
        return Arrays.asList(new E09_10.Box(4, 4, 4), new E09_10.Box(100, 100, 1), new E09_10.Box(3, 3, 3), new E09_10.Box(3, 2, 3), new E09_10.Box(1, 1, 1));
    }
}