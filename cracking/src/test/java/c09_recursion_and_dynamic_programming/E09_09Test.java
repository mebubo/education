package c09_recursion_and_dynamic_programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static c09_recursion_and_dynamic_programming.E09_09.queens;
import static c09_recursion_and_dynamic_programming.E09_09.queensHelper;
import static org.junit.Assert.*;

public class E09_09Test {

    @org.junit.Test
    public void testQueens() throws Exception {
        assertEquals(92, queens(8).size());
    }

    @org.junit.Test
    public void testQueensHelper() throws Exception {
        assertEquals(Arrays.asList(s(0), s(1), s(2)), queensHelper(3, 0).collect(Collectors.toList()));
    }

    private List<Integer> s(int i) {
        return Collections.singletonList(i);
    }
}