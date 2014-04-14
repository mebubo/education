package c01_arrays_and_strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E01_04Test {
    @Test
    public void testEscapeWhitespace() throws Exception {
        char[] input = "foo bar     ".toCharArray();
        E01_04.escapeWhitespace(input, 8);
        assertEquals("foo%20bar%20", new String(input));
    }
}
