package c04_trees_and_graphs;

public class E04_08 {
    public static <T> boolean isSubtree(BinaryTreeNode<T> t1, BinaryTreeNode<T> t2) {
        if (t1 == null) {
            return t2 == null;
        }
        return treeEquals(t1, t2) || isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    private static <T> boolean treeEquals(BinaryTreeNode<T> t1, BinaryTreeNode<T> t2) {
        if (t1 == null || t2 == null) {
            return t1 == t2;
        }
        return t1.equals(t2) && treeEquals(t1.left, t2.left) && treeEquals(t1.right, t2.right);
    }
}
