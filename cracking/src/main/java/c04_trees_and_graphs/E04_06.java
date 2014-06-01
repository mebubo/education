package c04_trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class E04_06 {
    public static BinaryTreeNode<?> findNext(BinaryTreeNode<?> node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode<?> result = node;
        if (node.right == null) {
            while (node.parent != null && result.equals(node.parent.right)) {
                result = result.parent;
            }
            return result.parent;
        }
        result = node.right;
        while (result.left != null) {
            result = result.left;
        }
        return result;
    }
}
