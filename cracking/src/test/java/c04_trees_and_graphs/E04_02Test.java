package c04_trees_and_graphs;

import org.junit.Test;

import java.util.Arrays;

import static c04_trees_and_graphs.E04_02.connected;
import static org.junit.Assert.*;

public class E04_02Test {

    @Test
    public void testConnected() throws Exception {
        GraphNode n1 = new GraphNode("1");
        assertTrue(connected(n1, n1));
        GraphNode n2 = new GraphNode("2");
        assertFalse(connected(n1, n2));
        n1.setChildren(Arrays.asList(n2));
        assertTrue(connected(n1, n2));
        n1.setChildren(Arrays.asList(n1, n2));
        assertTrue(connected(n1, n2));
        assertFalse(connected(n2, n1));
        n1.setChildren(Arrays.asList(n1));
        assertFalse(connected(n1, n2));
        GraphNode n3 = new GraphNode("3");
        n1.setChildren(Arrays.asList(n2));
        n2.setChildren(Arrays.asList(n3));
        assertTrue(connected(n1, n3));
        assertFalse(connected(n3, n1));
        n3.setChildren(Arrays.asList(n1));
        assertTrue(connected(n1, n3));
        assertTrue(connected(n3, n1));
    }
}