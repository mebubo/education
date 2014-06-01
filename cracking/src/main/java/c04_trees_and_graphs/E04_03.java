package c04_trees_and_graphs;

import java.util.Arrays;

public class E04_03 {
    public static <T> BinaryTreeNode<T> createBinarySearchTree(T[] input) {
        if (input.length == 0) {
            return null;
        }
        if (input.length == 1) {
            return new BinaryTreeNode<T>(input[0]);
        }
        int middle = getMiddleElementIndex(input.length);
        return new BinaryTreeNode<T>(input[middle],
                createBinarySearchTree(Arrays.<T>copyOfRange(input, 0, middle)),
                createBinarySearchTree(Arrays.<T>copyOfRange(input, middle+1, input.length)));
    }

    static int getMiddleElementIndex(int length) {
        return length / 2;
    }
}
