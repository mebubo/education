package c04_trees_and_graphs;

import org.junit.Test;

import java.util.Arrays;

import static c04_trees_and_graphs.E04_03.createBinarySearchTree;
import static c04_trees_and_graphs.E04_03.getMiddleElementIndex;
import static org.junit.Assert.*;

public class E04_03Test {

    @Test
    public void testGetMiddleElementIndex() throws Exception {
        assertEquals(1, getMiddleElementIndex(2));
        assertEquals(1, getMiddleElementIndex(3));
        assertEquals(2, getMiddleElementIndex(4));
        assertEquals(2, getMiddleElementIndex(5));
    }

    @Test
    public void testCreateBinarySearchTree() throws Exception {
        System.out.println(createBinarySearchTree(new String[]{}));
        System.out.println(createBinarySearchTree(new String[]{"1"}));
        System.out.println(createBinarySearchTree(new String[]{"1", "2"}));
        System.out.println(createBinarySearchTree(new String[]{"1", "2", "3"}));
        System.out.println(createBinarySearchTree(new String[]{"1", "2", "3", "4"}));
        System.out.println(createBinarySearchTree(new String[]{"1", "2", "3", "4", "5"}));
        System.out.println(createBinarySearchTree(new String[]{"1", "2", "3", "4", "5", "6"}));
        System.out.println(createBinarySearchTree(new String[]{"1", "2", "3", "4", "5", "6", "7"}));
    }
}
