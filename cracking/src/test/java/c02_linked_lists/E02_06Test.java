package c02_linked_lists;

import org.junit.Test;

import static c02_linked_lists.E02_06.detectLoop;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class E02_06Test {
    @Test
    public void testDetectLoop() throws Exception {
        Node l1 = new Node(1);
        Node l2 = new Node(2);
        Node l3 = new Node(3);
        Node l4 = new Node(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        assertNull(detectLoop(l1));
        l4.next = l2;
        Node loop = detectLoop(l1);
        assertEquals(2, loop.data);
        assertSame(l2, loop);
    }
}
