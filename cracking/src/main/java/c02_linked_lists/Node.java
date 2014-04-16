package c02_linked_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    void appendToTail(int data) {
        Node end = new Node(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public static Node deleteNode(Node head, int data) {
        if (head.data == data) {
            return head.next;
        }
        Node n = head;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }

    public static Node createList(int... data) {
        Node prev = null;
        Node result = null;
        for (int x : data) {
            Node n = new Node(x);
            if (prev != null) {
                prev.next = n;
            } else {
                result = n;
            }
            prev = n;
        }
        return result;
    }

    public static List<Integer> toList(Node head) {
        ArrayList<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.data);
            head = head.next;
        }
        return result;
    }

    public static void forEach(Node head, Consumer<Node> f) {
        while (head != null) {
            f.accept(head);
            head = head.next;
        }
    }

    public static void print(Node head) {
        forEach(head, (Node n) -> System.out.print(n.data + " -> "));
        System.out.println();
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node oldHead = head;
        head = head.next;
        oldHead.next = null;
        while (head != null) {
            Node newHead = head.next;
            head.next = oldHead;
            oldHead = head;
            head = newHead;
        }
        return oldHead;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Node)) {
            return false;
        }
        Node other = (Node) o;
        if (this.next == null) {
            return other.next == null && this.data == other.data;
        }
        return this.data == other.data && this.next.equals(other.next);
    }

    public static Node copy(Node head) {
        Node newHead = new Node(head.data);
        Node result = newHead;
        while (head.next != null) {
            newHead.next = new Node(head.next.data);
            newHead = newHead.next;
            head = head.next;
        }
        return result;
    }
}
