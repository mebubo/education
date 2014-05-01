package c03_stacks_and_queues;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class E03_06Test {
    @Test
    public void testSortStack() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        E03_06.sortStack(stack);
        assertEquals(5, (long) stack.pop());
        assertEquals(4, (long) stack.pop());
        assertEquals(3, (long) stack.pop());
        assertEquals(2, (long) stack.pop());
        assertEquals(1, (long)stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSortStack0() throws Exception {
        Stack<Integer> stack = new Stack<>();
        E03_06.sortStack(stack);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSortStack1() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        E03_06.sortStack(stack);
        assertEquals(0, (long)stack.pop());
        assertTrue(stack.isEmpty());
    }
}
