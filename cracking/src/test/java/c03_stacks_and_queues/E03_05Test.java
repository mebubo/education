package c03_stacks_and_queues;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class E03_05Test {
    @Test
    public void testQueue() throws Exception {
        E03_05<String> queue = new E03_05<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());
        queue.enqueue("d");
        assertEquals("c", queue.dequeue());
        assertEquals("d", queue.dequeue());
        assertNull(queue.dequeue());
    }
}
