package c11_sorting_and_searching;

import org.junit.Test;

import static c11_sorting_and_searching.E11_01.merge;
import static org.junit.Assert.*;

public class E11_01Test {

    @Test
    public void testMerge() throws Exception {
        int[] a = {1, 3, 6, 0, 0, 0};
        merge(a, new int[]{2, 4, 5}, 3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, a);

        a = new int[] {2, 4, 5, 0, 0, 0};
        merge(a, new int[]{1, 3, 6}, 3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, a);
    }
}