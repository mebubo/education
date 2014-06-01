package c04_trees_and_graphs;

import org.junit.Test;

import static c04_trees_and_graphs.E04_06.findNext;
import static org.junit.Assert.*;

public class E04_06Test {

    @Test
    public void testFindNext() throws Exception {
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

        assertEquals(n1, findNext(n4));
        assertEquals(n2, findNext(n3));
        assertEquals(n4, findNext(n5));
        assertEquals(n5, findNext(n2));
    }

    static <T> void connectLeft(BinaryTreeNode<T> parent, BinaryTreeNode<T> child) {
        parent.left = child;
        child.parent = parent;
    }

    static <T> void connectRight(BinaryTreeNode<T> parent, BinaryTreeNode<T> child) {
        parent.right = child;
        child.parent = parent;
    }
}