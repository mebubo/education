package c04_trees_and_graphs;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static c04_trees_and_graphs.E04_06Test.connectLeft;
import static c04_trees_and_graphs.E04_06Test.connectRight;
import static c04_trees_and_graphs.E04_09.pathsThatSumTo;
import static org.junit.Assert.*;

public class E04_09Test {

    @Test
    public void testPathsThatSumTo() throws Exception {
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(3);

        connectLeft(n1, n2);
        connectLeft(n2, n3);
        connectRight(n2, n4);
        connectLeft(n4, n5);
        connectRight(n1, n6);

        /*
         *        1
         *       / \
         *      2  3
         *     / \
         *    1  1
         *      /
         *     1
         */

        assertEquals(Arrays.asList("1", "1", "1", "1"), pathsThatSumTo(n1, 1));
        assertEquals(Arrays.asList("2", "1 > 1"), pathsThatSumTo(n1, 2));
        assertEquals(Arrays.asList("1 > 2", "2 > 1", "2 > 1", "3"), pathsThatSumTo(n1, 3));
        assertEquals(Arrays.asList("1 > 2 > 1", "1 > 2 > 1", "2 > 1 > 1", "1 > 3"), pathsThatSumTo(n1, 4));
        assertEquals(Arrays.asList("1 > 2 > 1 > 1"), pathsThatSumTo(n1, 5));
        assertEquals(Arrays.asList(), pathsThatSumTo(n1, 6));
        assertEquals(Arrays.asList(), pathsThatSumTo(null, 6));

    }
}