package c04_trees_and_graphs;

public class E04_01 {
    public static boolean isBalanced(BinaryTreeNode root) {
        int height = heightOrNonBalanced(root);
        return height >= 0;
    }

    private static int heightOrNonBalanced(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOrNonBalanced(root.left);
        int rightHeight = heightOrNonBalanced(root.right);
        if (leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
