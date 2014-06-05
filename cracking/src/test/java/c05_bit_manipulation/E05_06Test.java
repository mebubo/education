package c05_bit_manipulation;

import org.junit.Test;

import static c05_bit_manipulation.E05_06.swapOddAndEvenBits;
import static org.junit.Assert.*;

public class E05_06Test {

    @Test
    public void testSwapOddAndEvenBits() throws Exception {
        assertEquals(0b11100101, swapOddAndEvenBits(0b11011010));
    }
}