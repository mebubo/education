package c04_trees_and_graphs;

public class E04_05 {
    public static boolean isBinarySearchTree(BinaryTreeNode<Integer> tree) {
        return checkBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBST(BinaryTreeNode<Integer> tree, int min, int max) {
        if (tree == null) {
            return true;
        }
        if (tree.data < min || tree.data > max) {
            return false;
        }
        return checkBST(tree.left, min, tree.data) && checkBST(tree.right, tree.data, max);
    }

}
