package c04_trees_and_graphs;

import org.junit.Before;
import org.junit.Test;

import static c04_trees_and_graphs.E04_01.isBalanced;
import static org.junit.Assert.*;

public class E04_01Test {

    private BinaryTreeNode un;
    private BinaryTreeNode n3;
    private BinaryTreeNode n2;
    private BinaryTreeNode n1;

    @Before
    public void setUp() throws Exception {
        n1 = new BinaryTreeNode();
        n2 = new BinaryTreeNode(n1, n1);
        n3 = new BinaryTreeNode(n2, n1);
        un = new BinaryTreeNode(n3, n1);
    }

    @Test
    public void testIsBalanced() throws Exception {
        assertTrue(isBalanced(null));
        assertTrue(isBalanced(n1));
        assertTrue(isBalanced(n2));
        assertTrue(isBalanced(n3));
        assertFalse(isBalanced(un));
    }
}