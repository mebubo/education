package c02_linked_lists;

public class E02_04 {
    public static Node partition(Node head, int value) {
        Node less = null;
        Node lessHead = null;
        Node greater = null;
        Node greaterHead = null;
        while (head != null) {
            if (head.data < value) {
                if (less == null) {
                    less = head;
                    lessHead = head;
                } else {
                    less.next = head;
                    less = head;
                }
            } else {
                if (greater == null) {
                    greater = head;
                    greaterHead = head;
                } else {
                    greater.next = head;
                    greater = head;
                }
            }
            head = head.next;
        }
        if (less != null) {
            less.next = greaterHead;
        }
        if (greater != null) {
            greater.next = null;
        }
        return lessHead != null ? lessHead : greaterHead;
    }
}
