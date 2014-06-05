package c05_bit_manipulation;

import org.junit.Test;

import static c05_bit_manipulation.E05_03.nextLargestWithTheSameOnesCount;
import static c05_bit_manipulation.E05_03.nextSmallestWithTheSameOnesCount;
import static org.junit.Assert.*;

public class E05_03Test {

    @Test
    public void testNextSmallestWithTheSameOnesCount() throws Exception {
        assertEquals(0b10, nextSmallestWithTheSameOnesCount(0b1));
        assertEquals(0b10100, nextSmallestWithTheSameOnesCount(0b10010));
        assertEquals(0b101001, nextSmallestWithTheSameOnesCount(0b100110));
        assertEquals(0b1111111111111111111111111111111, nextSmallestWithTheSameOnesCount(0b1111111111111111111111111111111));
    }

    @Test
    public void testNextLargestWithTheSameOnesCount() throws Exception {
        assertEquals(0b1100000000000000000000000000000, nextLargestWithTheSameOnesCount(0b10010));
        assertEquals(0b1111111000000000000000000000000, nextLargestWithTheSameOnesCount(0b100101110100001));
        assertEquals(0b1111111111111111111111111111111, nextLargestWithTheSameOnesCount(0b1111111111111111111111111111111));
        assertEquals(0b0, nextLargestWithTheSameOnesCount(0b0));
    }
}