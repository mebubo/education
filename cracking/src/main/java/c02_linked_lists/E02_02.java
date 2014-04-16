package c02_linked_lists;

public class E02_02 {
    public static Node kthToLast(Node head, int k) {
        Node runner = head;
        Node current = head;
        for (int i = 0; i < k; i++) {
            if (runner == null) {
                throw new IndexOutOfBoundsException("List too short");
            }
            runner = runner.next;
        }
        while (runner != null) {
            runner = runner.next;
            current = current.next;
        }
        return current;
    }

    public static Node kthToLastRecursive(Node head, int k) {
        Node node = kthToLastHelper(head, k).node;
        if (node == null) {
            throw new IndexOutOfBoundsException("List too short");
        }
        return node;
    }

    private static NodeAndCount kthToLastHelper(Node node, int k) {
        if (node == null) {
            return new NodeAndCount(null, 1);
        }
        NodeAndCount nodeAndCount = kthToLastHelper(node.next, k);
        if (nodeAndCount.count == k && nodeAndCount.node == null) {
            return new NodeAndCount(node, k);
        }
        nodeAndCount.count++;
        return nodeAndCount;
    }

    private static class NodeAndCount {
        Node node;
        int count;

        private NodeAndCount(Node node, int count) {
            this.node = node;
            this.count = count;
        }
    }
}
