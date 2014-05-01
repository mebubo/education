package c03_stacks_and_queues;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class E03_03Test {
    @Test
    public void test() throws Exception {
        E03_03<Integer> stack = new E03_03<>(2);
        stack.push(1);
        stack.push(2);
        assertEquals(1, stack.size());
        stack.push(3);
        assertEquals(2, stack.size());
        stack.push(4);
        assertEquals(2, stack.size());
        stack.push(5);
        assertEquals(3, stack.size());
        assertEquals(5, (long) stack.pop());
        assertEquals(2, stack.size());
        assertEquals(4, (long) stack.pop());
        assertEquals(2, stack.size());
        assertEquals(3, (long) stack.pop());
        assertEquals(1, stack.size());
        assertEquals(2, (long) stack.pop());
        assertEquals(1, stack.size());
        assertEquals(1, (long) stack.pop());
        assertEquals(0, stack.size());
        assertNull(stack.pop());
        assertNull(stack.pop());

    }
}
