package c04_trees_and_graphs;

import org.junit.Test;

import static c04_trees_and_graphs.E04_06Test.connectLeft;
import static c04_trees_and_graphs.E04_06Test.connectRight;
import static c04_trees_and_graphs.E04_07.firstCommonAncestor;
import static org.junit.Assert.*;

public class E04_07Test {

    @Test
    public void testFirstCommonAncestor() throws Exception {
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

        assertEquals(n1, firstCommonAncestor(n1, n2, n6));
        assertEquals(n1, firstCommonAncestor(n1, n3, n6));
        assertEquals(n2, firstCommonAncestor(n1, n3, n5));
        assertEquals(n4, firstCommonAncestor(n1, n4, n4));
        assertEquals(n1, firstCommonAncestor(n1, n1, n1));
        assertEquals(n2, firstCommonAncestor(n1, n2, n5));
        assertNull(firstCommonAncestor(n2, n3, n6));
        assertNull(firstCommonAncestor(null, n3, n6));
        assertNull(firstCommonAncestor(n1, null, n6));
        assertNull(firstCommonAncestor(n1, n2, null));
        assertNull(firstCommonAncestor(n1, n2, new BinaryTreeNode<Integer>(7)));
    }
}