package c02_linked_lists;

public class E02_03 {
    public static void deleteInTheMiddle(Node node) {
        if (node.next == null) {
            throw new RuntimeException("Cannot delete the last node");
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
