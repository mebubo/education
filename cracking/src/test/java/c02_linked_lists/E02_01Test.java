package c02_linked_lists;

import org.junit.Test;

import java.util.Arrays;

import static c02_linked_lists.E02_01.removeDuplicates;
import static c02_linked_lists.Node.toList;
import static c02_linked_lists.Node.createList;
import static org.junit.Assert.assertEquals;

public class E02_01Test {
    @Test
    public void testRemoveDuplicates() throws Exception {
        assertEquals(Arrays.asList(1, 2, 3), toList(removeDuplicates(createList(1, 2, 3))));
        assertEquals(Arrays.asList(1), toList(removeDuplicates(createList(1, 1, 1))));
        assertEquals(Arrays.asList(1), toList(removeDuplicates(createList(1))));
        assertEquals(Arrays.asList(1, 3, 5, 7, 2, 6), toList(removeDuplicates(createList(1, 3, 5, 3, 3, 7, 1, 3, 2, 1, 6))));
    }
}
