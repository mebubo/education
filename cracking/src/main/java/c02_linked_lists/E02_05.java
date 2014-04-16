package c02_linked_lists;

import static c02_linked_lists.Node.reverse;

public class E02_05 {
    public static Node sum(Node x, Node y) {
        Node result = null;
        Node resultHead = null;
        int carry = 0;
        while (x != null || y != null || carry != 0) {
            int cy = 0;
            int cx = 0;
            if (x != null) {
                cx = x.data;
                x = x.next;
            }
            if (y != null) {
                cy = y.data;
                y = y.next;
            }
            if (result == null) {
                result = new Node(lastDigit(cx + cy + carry));
                resultHead = result;
            } else {
                result.next = new Node(lastDigit(cx + cy + carry));
                result = result.next;
            }
            carry = carry(cx + cy + carry);
        }
        return resultHead;
    }

    private static int lastDigit(int i) {
        return i % 10;
    }

    private static int carry(int i) {
        return i / 10;
    }

    public static Node sumForward(Node x, Node y) {
        return reverse(sum(reverse(x), reverse(y)));
    }

    public static void main(String[] args) {
        Node.print(sum(Node.createList(9, 9), Node.createList(9, 9)));
        Node.print(sum(Node.createList(1, 0, 0), Node.createList(1, 0)));
        Node.print(sumForward(Node.createList(1, 2, 9), Node.createList(1)));
    }
}
