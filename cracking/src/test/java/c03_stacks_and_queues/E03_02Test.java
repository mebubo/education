package c03_stacks_and_queues;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class E03_02Test {
    @Test
    public void testMin() throws Exception {
        E03_02<Integer> stack = new E03_02<>();
        assertNull(stack.min());
        stack.push(1);
        assertEquals(1, (long) stack.min());
        stack.push(1);
        assertEquals(1, (long) stack.min());
        stack.push(0);
        assertEquals(0, (long) stack.min());
        stack.push(0);
        assertEquals(0, (long) stack.min());
        stack.push(1);
        assertEquals(0, (long) stack.min());
        stack.pop();
        assertEquals(0, (long) stack.min());
        stack.pop();
        assertEquals(0, (long) stack.min());
        stack.pop();
        assertEquals(1, (long) stack.min());
        stack.pop();
        assertEquals(1, (long) stack.min());
        stack.pop();
        assertNull(stack.min());
    }

    @Test
    public void testMinRandomized() throws Exception {
        E03_02<Integer> stack = new E03_02<>();
        List<Integer> check = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_000; i++) {
            int k = random.nextInt(10);
            stack.push(k);
            check.add(k);
            assertEquals(Collections.min(check), stack.min());
        }
        do {
            assertEquals(Collections.min(check), stack.min());
            Integer k = stack.pop();
            check.remove(k);
        } while (!check.isEmpty());
    }
}
