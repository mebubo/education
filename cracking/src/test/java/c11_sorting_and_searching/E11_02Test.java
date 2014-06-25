package c11_sorting_and_searching;

import org.junit.Test;

import static c11_sorting_and_searching.E11_02.sortAnagramsTogether;
import static org.junit.Assert.*;

public class E11_02Test {

    @Test
    public void testSortAnagramsTogether() throws Exception {
        String[] a = {"zab", "foo", "bar", "ofo", "baz"};
        sortAnagramsTogether(a);
        assertArrayEquals(new String[]{"bar", "zab", "baz", "foo", "ofo"}, a);
    }
}