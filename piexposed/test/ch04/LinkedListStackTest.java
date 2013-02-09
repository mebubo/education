package ch04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LinkedListStackTest {

    private Stack<String> stack;

    @Before
    public void setUp() {
        stack = new LinkedListStack<>();
    }

    @Test
    public void testEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPopEmpty() {
        stack.pop();
    }

    @Test
    public void testPushPop() {
        stack.push("foo");
        assertFalse(stack.isEmpty());
        assertEquals("foo", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testMultiPushPop() {
        for (int i = 0; i < 100; i++) {
            stack.push("foo" + i);
        }
        for (int i = 99; i >= 0; i--) {
            assertFalse(stack.isEmpty());
            assertEquals("foo" + i, stack.pop());
        }
        assertTrue(stack.isEmpty());
    }

}
