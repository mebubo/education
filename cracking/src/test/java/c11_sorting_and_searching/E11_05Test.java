package c11_sorting_and_searching;

import org.junit.Test;

import static c11_sorting_and_searching.E11_05.binarySearchInArrayWithPossibleEmptyStrings;
import static org.junit.Assert.*;

public class E11_05Test {

    @Test
    public void testBinarySearchInArrayWithPossibleEmptyStrings() throws Exception {
        assertEquals(1, binarySearchInArrayWithPossibleEmptyStrings(new String[] {"", "aoo", "bar", "", "", "caz", "doo"}, "aoo"));
        assertEquals(1, binarySearchInArrayWithPossibleEmptyStrings(new String[] {"", "aoo", "", "", "", "", ""}, "aoo"));
        assertEquals(5, binarySearchInArrayWithPossibleEmptyStrings(new String[] {"", "aoo", "bar", "", "", "caz", "doo"}, "caz"));
        assertEquals(0, binarySearchInArrayWithPossibleEmptyStrings(new String[] {"aoo", "bar", "", "", "caz", "doo"}, "aoo"));
        assertEquals(6, binarySearchInArrayWithPossibleEmptyStrings(new String[] {"", "aoo", "bar", "", "", "caz", "doo"}, "doo"));
    }
}