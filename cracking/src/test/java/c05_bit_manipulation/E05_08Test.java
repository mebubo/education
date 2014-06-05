package c05_bit_manipulation;

import org.junit.Test;

import static c05_bit_manipulation.E05_08.drawLine;
import static c05_bit_manipulation.E05_08.setBits;
import static org.junit.Assert.*;

public class E05_08Test {

    @Test
    public void testDrawLine() throws Exception {
        assertArrayEquals(new byte[]{0b00111000, 0, 0,
                0, 0, 0,
                0, 0, 0}, drawLine(new byte[9], 3 * 8, 2, 4, 0));
        assertArrayEquals(new byte[]{0b00111111, (byte)0b11111111, (byte)0b10000000,
                0, 0, 0,
                0, 0, 0}, drawLine(new byte[9], 3 * 8, 2, 16, 0));
        assertArrayEquals(new byte[]{0b00111111, (byte)0b11111111, 0,
                0, 0, 0,
                0, 0, 0}, drawLine(new byte[9], 3 * 8, 2, 15, 0));
        assertArrayEquals(new byte[]{0, (byte)0b00111111, (byte)0b11111111,
                0, 0, 0,
                0, 0, 0}, drawLine(new byte[9], 3 * 8, 10, 100, 0));
        assertArrayEquals(new byte[]{0, 0, 0,
                0b00111111, (byte) 0b11111111, (byte) 0b10000000,
                0, 0, 0}, drawLine(new byte[9], 3 * 8, 2, 16, 1));
    }

    @Test
    public void testSetBits() throws Exception {
        assertEquals(0b00111100, setBits(2, 5));
        assertEquals(0b00111111, setBits(0, 5));
        assertEquals((byte)0b11111100, setBits(2, 7));
        assertEquals((byte)0b00000000, setBits(7, 2));
        assertEquals((byte)0b00000001, setBits(0, 0));
        assertEquals((byte)0b10000000, setBits(7, 7));
        assertEquals((byte)0, setBits(9, 11));
        assertEquals((byte)0, setBits(9, 11));
    }
}