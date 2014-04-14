package c01_arrays_and_strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class E01_08Test {
    @Test
    public void testIsRotation() throws Exception {
        assertTrue(E01_08.isRotation("waterbottle", "erbottlewat"));
        assertTrue(E01_08.isRotation("erbottlewat", "waterbottle"));
        assertFalse(E01_08.isRotation("erbottlewat", "waterbgttle"));
    }
}
