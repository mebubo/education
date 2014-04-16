package c02_linked_lists;

import org.junit.Test;

import java.util.Arrays;

import static c02_linked_lists.E02_04.partition;
import static c02_linked_lists.Node.toList;
import static c02_linked_lists.Node.createList;
import static org.junit.Assert.assertEquals;

public class E02_04Test {
    @Test
    public void testPartition() throws Exception {
        assertEquals(Arrays.asList(1, 4, 3, 5, 3, 5, 6, 6, 8, 8, 9),
                toList(partition(createList(1, 4, 6, 3, 6, 8, 5, 3, 8, 9, 5), 6)));
        assertEquals(Arrays.asList(1, 2, 3), toList(partition(createList(1, 2, 3), 10)));
        assertEquals(Arrays.asList(1, 2, 3), toList(partition(createList(1, 2, 3), 0)));
    }
}
