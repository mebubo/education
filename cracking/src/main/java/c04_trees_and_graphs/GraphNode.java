package c04_trees_and_graphs;

import java.util.Collection;
import java.util.Collections;

public class GraphNode {
    private Collection<GraphNode> children = Collections.emptyList();
    private String data;

    public GraphNode(String data) {
        this.data = data;
    }

    public GraphNode(Collection<GraphNode> children, String data) {

        this.children = children;
        this.data = data;
    }

    public GraphNode(Collection<GraphNode> children) {
        this.children = children;
    }

    public void setChildren(Collection<GraphNode> children) {
        this.children = children;
    }

    public Collection<GraphNode> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphNode graphNode = (GraphNode) o;

        if (data != null ? !data.equals(graphNode.data) : graphNode.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
