package c01_arrays_and_strings;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class E01_05Test {
    @Test
    public void testCompress() throws Exception {
        for (Function<String, String> method :
                Arrays.<Function<String, String>>asList(E01_05::compressUgly, E01_05::compressWithStringBuffer)) {
            assertEquals("a6b2c3d1e1f1g4h1", method.apply("aaaaaabbcccdefggggh"));
            assertEquals("abcd", method.apply("abcd"));
            assertEquals("abbb", method.apply("abbb"));
            assertEquals("a1b4", method.apply("abbbb"));
            assertEquals("", method.apply(""));
            assertEquals("a", method.apply("a"));
        }
    }
}
