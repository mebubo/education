package c09_recursion_and_dynamic_programming;

import org.junit.Test;

import static c09_recursion_and_dynamic_programming.E09_03.magicIndex;
import static org.junit.Assert.*;

public class E09_03Test {

    @Test
    public void testMagicIndex() throws Exception {
        assertEquals(0, magicIndex(new int[] {0}));
        assertEquals(-1, magicIndex(new int[] {}));
        assertEquals(0, magicIndex(new int[] {0, 2}));
        assertEquals(1, magicIndex(new int[] {-1, 1}));
        assertEquals(5, magicIndex(new int[] {-100, -10, -1, 0, 1, 5, 7, 10, 100}));
        assertEquals(-1, magicIndex(new int[] {-100, -10, -1, 0, 1, 6, 7, 10, 100}));
        assertEquals(1, magicIndex(new int[] {-100, 1, 1, 1, 1, 6, 7, 10, 100}));
        assertEquals(5, magicIndex(new int[] {-100, -10, -1, 0, 5, 5, 7, 10, 100}));
    }
}