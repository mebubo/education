package c05_bit_manipulation;

import org.junit.Test;

import static c05_bit_manipulation.E05_01.insert;
import static org.junit.Assert.*;

public class E05_01Test {

    @Test
    public void testInsert() throws Exception {
        assertEquals(0b10001001100, insert(0b10000000000, 0b10011, 2, 6));
    }
}