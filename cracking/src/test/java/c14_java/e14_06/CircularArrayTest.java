package c14_java.e14_06;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class CircularArrayTest {

    @Test
    public void rotation() {
        CircularArray<Integer> a = new CircularArray<>(new Integer[]{1, 2, 3});
        assertArrayEquals(new Integer[]{1, 2, 3}, a.toArray());
        a.rotate(1);
        assertArrayEquals(new Integer[]{2, 3, 1}, a.toArray());
        a.set(-1, 10);
        assertArrayEquals(new Integer[]{2, 3, 10}, a.toArray());
        a.set(-2, 10);
        assertArrayEquals(new Integer[]{2, 10, 10}, a.toArray());
        a.rotate(-5);
        assertArrayEquals(new Integer[]{10, 10, 2}, a.toArray());
    }

    @Test
    public void iteration() {
        CircularArray<Integer> a = new CircularArray<>(new Integer[]{1, 2, 3});
        a.rotate(2);
        Iterator<Integer> iterator = a.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(3, (long)iterator.next());
        assertEquals(1, (long)iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, (long)iterator.next());
        assertFalse(iterator.hasNext());
    }

}