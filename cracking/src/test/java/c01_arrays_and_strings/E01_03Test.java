package c01_arrays_and_strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class E01_03Test {
    @Test
    public void testIsPermutation() throws Exception {
        assertTrue(E01_03.isPermutation("foo", "ofo"));
        assertTrue(E01_03.isPermutation("foo", "foo"));
        assertTrue(E01_03.isPermutation("foo", "oof"));
        assertTrue(E01_03.isPermutation("", ""));
        assertTrue(E01_03.isPermutation("f", "f"));
        assertFalse(E01_03.isPermutation("fa", "fb"));
        assertFalse(E01_03.isPermutation("ff", "f"));
        assertFalse(E01_03.isPermutation("f", ""));
        assertFalse(E01_03.isPermutation("ff", "ao"));
    }
}
