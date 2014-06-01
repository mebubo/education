package c04_trees_and_graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class E04_09 {
    public static List<String> pathsThatSumTo(BinaryTreeNode<Integer> tree, int sum) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        pathsThatSumToHelper(tree, sum, result, path);
        return result;
    }

    private static void pathsThatSumToHelper(BinaryTreeNode<Integer> tree, int sum, ArrayList<String> result, ArrayList<Integer> path) {
        if (tree == null) {
            return;
        }
        path.add(tree.data);
        int s = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            s += path.get(i);
            if (s == sum) {
                result.add(makePath(path.subList(i, path.size())));
            }
        }
        pathsThatSumToHelper(tree.left, sum, result, path);
        pathsThatSumToHelper(tree.right, sum, result, path);
        path.remove(path.size() - 1);
    }

    private static String makePath(List<Integer> subList) {
        return String.join(" > ", subList.stream().map(i -> i.toString()).collect(Collectors.toList()));
    }

}
