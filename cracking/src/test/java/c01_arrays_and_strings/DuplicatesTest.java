package c01_arrays_and_strings;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DuplicatesTest {
    @Test
    public void testRemoveDuplicateChars() throws Exception {
        assertEquals(Duplicates.removeDuplicateChars("aaaa"), "a");
        assertEquals(Duplicates.removeDuplicateChars("aaaafffff"), "af");
        assertEquals(Duplicates.removeDuplicateChars("asdf"), "asdf");
        assertEquals(Duplicates.removeDuplicateChars(""), "");
    }
}
