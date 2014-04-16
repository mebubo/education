package c02_linked_lists;

import org.junit.Test;

import static c02_linked_lists.Node.copy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import static c02_linked_lists.Node.createList;

public class NodeTest {
    @Test
    public void testEquals() throws Exception {
        assertTrue(createList(1, 2, 3).equals(createList(1, 2, 3)));
        assertTrue(createList(1).equals(createList(1)));
        assertFalse(createList(1).equals(createList(1, 2)));
        assertFalse(createList(1, 2).equals(createList(1)));
        assertFalse(createList(1).equals(null));
        assertFalse(createList(1).equals("foo"));
    }

    @Test
    public void testCopy() {
        Node l1 = createList(1, 2, 3);
        Node l2 = copy(l1);
        assertNotSame(l1, l2);
        assertNotSame(l1.next, l2.next);
        assertEquals(l1, l2);
        assertEquals(l1.next, l2.next);
    }

}
