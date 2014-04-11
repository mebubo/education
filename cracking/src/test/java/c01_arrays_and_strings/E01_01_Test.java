package c01_arrays_and_strings;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class E01_01_Test {
    @Test
    public void testAllUnique() throws Exception {
        test(E01_01::allUnique);
    }

    @Test
    public void testAllUnique2() throws Exception {
        test(E01_01::allUniqueNoAdditionalStorage);
    }

    private void test(Predicate<String> predicate) {
        assertFalse(predicate.test("foo"));

        assertTrue(predicate.test("qwerty"));
        assertTrue(predicate.test(""));
        assertTrue(predicate.test("Aa"));
    }
}
