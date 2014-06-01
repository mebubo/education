package c04_trees_and_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class E04_04 {
    public static List<BinaryTreeNode<String>> getNodesAtDepth(BinaryTreeNode<String> tree, int depth) {
        ArrayList<BinaryTreeNode<String>> result = new ArrayList<>();
        search(tree, depth, result);
        return result;
    }

    private static void search(BinaryTreeNode<String> tree, int depth, ArrayList<BinaryTreeNode<String>> result) {
        if (tree == null) {
            return;
        }
        if (depth == 0) {
            result.add(tree);
            return;
        }
        search(tree.left, depth - 1, result);
        search(tree.right, depth - 1, result);
    }

/*
    public static List<BinaryTreeNode> getNodesAtDepth2(BinaryTreeNode tree, int depth) {
        ArrayList<BinaryTreeNode> result = new ArrayList<>();
        BiConsumer<BinaryTreeNode, Integer> s = (BinaryTreeNode t, int d) -> {
            if (t == null) {
                return;
            }
            if (d == 0) {
                result.add(t);
                return;
            }
            s.apply(t.left, d - 1);
            s.apply(t.right, d - 1);
        };
        search(tree, depth, result);
        return result;
    }
*/

    public static List<List<BinaryTreeNode<String>>> createLevelLists(BinaryTreeNode<String> tree) {
        List<List<BinaryTreeNode<String>>> result = new LinkedList<>();
        List<BinaryTreeNode<String>> current = new LinkedList<>();
        if (tree != null) {
            current.add(tree);
        }
        while (!current.isEmpty()) {
            result.add(current);
            List<BinaryTreeNode<String>> parents = current;
            current = new LinkedList<>();
            for (BinaryTreeNode n : parents) {
                for (BinaryTreeNode child : Arrays.asList(n.left, n.right)) {
                    if (child != null) {
                        current.add(child);
                    }
                }
            }
        }
        return result;
    }
}