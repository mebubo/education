package c05_bit_manipulation;

import org.junit.Test;

import static c05_bit_manipulation.E05_05.bitSwapsRequired;
import static org.junit.Assert.*;

public class E05_05Test {

    @Test
    public void testBitSwapsRequired() throws Exception {
        assertEquals(0, bitSwapsRequired(0b1, 0b1));
        assertEquals(0, bitSwapsRequired(0b0, 0b0));
        assertEquals(1, bitSwapsRequired(0b1, 0b0));
        assertEquals(1, bitSwapsRequired(0b0, 0b1));
        assertEquals(3, bitSwapsRequired(0b101100, 0b101));
    }
}