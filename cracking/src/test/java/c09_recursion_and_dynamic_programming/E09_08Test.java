package c09_recursion_and_dynamic_programming;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static c09_recursion_and_dynamic_programming.E09_08.change;
import static c09_recursion_and_dynamic_programming.Utils.getSet;
import static org.junit.Assert.*;

public class E09_08Test {

    @Test
    public void testChange() throws Exception {
        assertEquals(new HashSet<>(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 1, 1))),
                change(3, Arrays.asList(2, 1)));
        assertEquals(new HashSet<List<Integer>>(Arrays.asList(Arrays.asList(1, 1, 2), Arrays.asList(1, 1, 1, 1), Arrays.asList(2, 2))),
                change(4, Arrays.asList(2, 1)));
        assertEquals(new HashSet<List<Integer>>(Arrays.asList(Arrays.asList(2, 3))),
                change(5, Arrays.asList(3, 2)));
        assertEquals(new HashSet<>(Arrays.asList(Arrays.asList(1))),
                change(1, Arrays.asList(1)));
    }
}