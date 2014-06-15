package c09_recursion_and_dynamic_programming;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static c09_recursion_and_dynamic_programming.E09_05.insert;
import static c09_recursion_and_dynamic_programming.E09_05.permutations;
import static org.junit.Assert.assertEquals;

public class E09_05Test {

    @Test
    public void testPermutations() throws Exception {
        assertEquals(new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba")), permutations("abc"));
        assertEquals(new HashSet<>(Arrays.asList("")), permutations(""));
        assertEquals(new HashSet<>(Arrays.asList("a")), permutations("a"));
    }

    @Test
    public void testInsert() throws Exception {
        assertEquals(Arrays.asList("xab", "axb", "abx"), insert('x', "ab"));
        assertEquals(Arrays.asList("x"), insert('x', ""));
    }
}