package c04_trees_and_graphs;

public class E04_07 {
    public static <T> BinaryTreeNode<T> firstCommonAncestor(BinaryTreeNode<T> tree,
                                                        BinaryTreeNode<T> n1, BinaryTreeNode<T> n2) {
        return firstCommonAncestorHelper(tree, n1, n2).result;
    }

    private static class Result <T> {
        boolean contains1;
        boolean contains2;
        BinaryTreeNode<T> result;

        private Result(boolean contains1, boolean contains2, BinaryTreeNode<T> result) {
            this.contains1 = contains1;
            this.contains2 = contains2;
            this.result = result;
        }

    }

    private static <T> Result<T> firstCommonAncestorHelper(BinaryTreeNode<T> tree,
                                                        BinaryTreeNode<T> n1, BinaryTreeNode<T> n2) {
        if (tree == null) {
            return new Result<>(false, false, null);
        }
        Result<T> l = firstCommonAncestorHelper(tree.left, n1, n2);
        Result<T> r = firstCommonAncestorHelper(tree.right, n1, n2);
        if (l.result != null) {
            return l;
        }
        if (r.result != null) {
            return r;
        }
        if (((l.contains1 || tree.equals(n1)) && (r.contains2 || tree.equals(n2))) ||
                ((l.contains2 || tree.equals(n2)) && (r.contains1 || tree.equals(n1)))) {
            return new Result<>(true, true, tree);
        }
        return new Result<>(l.contains1 || r.contains1 || tree.equals(n1),
                l.contains2 || r.contains2 || tree.equals(n2), null);

    }

}
