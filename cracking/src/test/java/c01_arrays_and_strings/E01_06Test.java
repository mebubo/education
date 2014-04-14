package c01_arrays_and_strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class E01_06Test {
    static int[][][][] testCases = new int[][][][]{
            {{{}}, {{}}},
            {{{1}}, {{1}}},
            {{{1, 2}, {4, 3}}, {{2, 3}, {1, 4}}},
            {{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, {{3, 4, 5}, {2, 9, 6}, {1, 8, 7}}},
            {{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}},
                    {{4, 5, 6, 7}, {3, 14, 15, 8}, {2, 13, 16, 9}, {1, 12, 11, 10}}},
    };

    @Test
    public void testRotate() throws Exception {
        for (int[][][] testCase : testCases) {
            int[][] input = testCase[0];
            int[][] expected = testCase[1];
            E01_06.rotate(input);
            assertArrayEquals(expected, input);
        }
    }
}
