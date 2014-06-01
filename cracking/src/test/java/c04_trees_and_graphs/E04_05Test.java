package c04_trees_and_graphs;

import org.junit.Test;

import static c04_trees_and_graphs.E04_03.createBinarySearchTree;
import static c04_trees_and_graphs.E04_05.isBinarySearchTree;
import static org.junit.Assert.*;

public class E04_05Test {

    @Test
    public void testIsBinarySearchTree() throws Exception {
        assertTrue(isBinarySearchTree(null));
        assertTrue(isBinarySearchTree(new BinaryTreeNode<Integer>(1)));
        BinaryTreeNode<Integer> good = createBinarySearchTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        assertTrue(isBinarySearchTree(good));
        BinaryTreeNode<Integer> bad = createBinarySearchTree(new Integer[]{1, 2, 9, 4, 5, 6, 7});
        assertFalse(isBinarySearchTree(bad));
    }
}