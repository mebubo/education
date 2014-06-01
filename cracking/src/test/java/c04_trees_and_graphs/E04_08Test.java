package c04_trees_and_graphs;

import org.junit.Test;

import static c04_trees_and_graphs.E04_06Test.connectLeft;
import static c04_trees_and_graphs.E04_06Test.connectRight;
import static c04_trees_and_graphs.E04_08.isSubtree;
import static org.junit.Assert.*;

public class E04_08Test {

    @Test
    public void testIsSubtree() throws Exception {
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);

        connectLeft(n1, n2);
        connectLeft(n2, n3);
        connectRight(n2, n4);
        connectLeft(n4, n5);
        connectRight(n1, n6);

        assertTrue(isSubtree(n1, n1));
        assertTrue(isSubtree(n2, n3));
        assertTrue(isSubtree(n1, n2));
        assertTrue(isSubtree(n1, n5));
        assertTrue(isSubtree(n1, n6));
        assertTrue(isSubtree(null, null));
        assertTrue(isSubtree(n1, null));
        assertFalse(isSubtree(null, n1));
        assertFalse(isSubtree(n4, n6));
        assertFalse(isSubtree(n4, n1));
        assertFalse(isSubtree(n4, n2));
        assertFalse(isSubtree(n1, new BinaryTreeNode<Integer>(0)));
        assertFalse(isSubtree(new BinaryTreeNode<Integer>(0), n6));
    }
}