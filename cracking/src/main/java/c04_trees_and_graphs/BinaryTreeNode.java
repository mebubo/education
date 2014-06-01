package c04_trees_and_graphs;

public class BinaryTreeNode<T> {
    public BinaryTreeNode() {

    }

    public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right) {
        this.left = left;
        this.right = right;
    }

    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    BinaryTreeNode<T> parent;

    T data;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode left, BinaryTreeNode right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("{%s %s %s}", left == null ? "." : left, data, right == null ? "." : right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinaryTreeNode that = (BinaryTreeNode) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
