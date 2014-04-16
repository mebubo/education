package c02_linked_lists;

import java.util.HashSet;
import java.util.Set;

public class E02_01 {
    public static Node removeDuplicatesUgly(Node head) {
        if (head.next == null) {
            return head;
        }
        int resultLength = 1;
        Node oldTail = head.next;
        while (oldTail != null) {
            Node a = head;
            boolean duplicate = false;
            for (int i = 0; i < resultLength; i++) {
                if (oldTail.data == a.data) {
                    duplicate = true;
                    break;
                }
                if (i != resultLength - 1) {
                    a = a.next;
                }
            }
            if (!duplicate) {
                a.next = oldTail;
                resultLength++;
            }
            oldTail = oldTail.next;
        }
        Node n = head;
        for (int i = 0; i < resultLength - 1; i++) {
            n = n.next;
        }
        n.next = null;
        return head;
    }

    public static Node removeDuplicates(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    public static Node removeDuplicatesWithSet(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        Set<Integer> seen = new HashSet<>();
        seen.add(head.data);
        while (current.next != null) {
            if (seen.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                seen.add(current.next.data);
                current = current.next;
            }
        }
        return head;
    }

    public static Node removeDuplicatesWithSet2(Node head) {
        Node originalHead = head;
        Node previous = null;
        Set<Integer> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head.data)) {
                previous.next = head.next;
            } else {
                seen.add(head.data);
                previous = head;
            }
            head = head.next;
        }
        return originalHead;
    }
}
