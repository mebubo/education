package c04_trees_and_graphs;

import java.util.ArrayList;

public class E04_02 {
    public static boolean connected(GraphNode start, GraphNode end) {
        ArrayList<GraphNode> visited = new ArrayList<>();
        return connectedHelper(start, end, visited);
    }

    private static boolean connectedHelper(GraphNode start, GraphNode end, ArrayList<GraphNode> visited) {
        if (start == null) {
            return false;
        }
        if (start.equals(end)) {
            return true;
        }
        for (GraphNode node : start.getChildren()) {
            if (!visited.contains(node)) {
                visited.add(node);
                if (connectedHelper(node, end, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
