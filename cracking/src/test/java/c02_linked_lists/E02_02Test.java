package c02_linked_lists;

import org.junit.Test;

import static c02_linked_lists.Node.createList;
import static org.junit.Assert.assertEquals;

public class E02_02Test {
    @Test
    public void testKthToLast() throws Exception {
        assertEquals(5, E02_02.kthToLast(createList(1, 2, 3, 4, 5, 6), 2).data);
        assertEquals(6, E02_02.kthToLast(createList(1, 2, 3, 4, 5, 6), 1).data);
        assertEquals(1, E02_02.kthToLast(createList(1, 2, 3, 4, 5, 6), 6).data);
        assertEquals(1, E02_02.kthToLast(createList(1), 1).data);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testTooShort() {
        E02_02.kthToLast(createList(1, 2, 3, 4, 5, 6), 7);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testTooShort2() {
        E02_02.kthToLast(createList(1), 2);
    }
}
