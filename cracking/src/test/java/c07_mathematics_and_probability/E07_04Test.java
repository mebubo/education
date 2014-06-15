package c07_mathematics_and_probability;

import org.junit.Test;

import static c07_mathematics_and_probability.E07_04.divide;
import static c07_mathematics_and_probability.E07_04.multiply;
import static c07_mathematics_and_probability.E07_04.subtract;
import static org.junit.Assert.*;

public class E07_04Test {

    @Test
    public void testSubtract() throws Exception {
        assertEquals(10 - 1, subtract(10, 1));
        assertEquals(10 - 11, subtract(10, 11));
        assertEquals(-1 - 2, subtract(-1, 2));
    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(10 * 1, multiply(10, 1));
        assertEquals(10 * -11, multiply(10, -11));
        assertEquals(-1 * 2, multiply(-1, 2));
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(10 / 1, divide(10, 1));
        assertEquals(10 / 2, divide(10, 2));
        assertEquals(10 / -11, divide(10, -11));
        assertEquals(-1 / 2, divide(-1, 2));
        assertEquals(-5 / 2, divide(-5, 2));
    }
}