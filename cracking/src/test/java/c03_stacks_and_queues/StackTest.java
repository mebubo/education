package c03_stacks_and_queues;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StackTest {
    @Test
    public void testStack() throws Exception {
        Stack<String> stack = new Stack<>();
        assertNull(stack.pop());
        assertNull(stack.peek());

        stack.push("foo");
        assertEquals("foo", stack.peek());
        assertEquals("foo", stack.pop());
        assertNull(stack.pop());

        stack.push("1");
        stack.push("2");
        stack.push("3");
        assertEquals("3", stack.pop());
        assertEquals("2", stack.pop());
        assertEquals("1", stack.pop());
        assertNull(stack.pop());
    }
}
