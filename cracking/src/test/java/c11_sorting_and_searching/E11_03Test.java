package c11_sorting_and_searching;

import org.junit.Test;

import static c11_sorting_and_searching.E11_03.searchInRotated;
import static org.junit.Assert.*;

public class E11_03Test {

    @Test
    public void testSearchInRotated() throws Exception {
        assertEquals(8, searchInRotated(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
        assertEquals(5, searchInRotated(new int[]{2, 2, 2, 2, 2, 3, 4, 2}, 3));
    }
}