package c05_bit_manipulation;

import org.junit.Test;

import static c05_bit_manipulation.E05_02.toBinary;
import static org.junit.Assert.*;

public class E05_02Test {

    @Test
    public void testToBinary() throws Exception {
        assertEquals("0.11001", toBinary(1./2 + 1./4 + 1./32));
        assertEquals("1.", toBinary(1.));
        assertEquals("0.1", toBinary(0.5));
        assertEquals("0.", toBinary(0));
        assertEquals("ERROR", toBinary(-1));
        assertEquals("ERROR", toBinary(1.1));
        assertEquals("ERROR", toBinary(0.72));
    }
}