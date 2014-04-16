package c02_linked_lists;

import java.util.IdentityHashMap;
import java.util.Map;

public class E02_06 {
    public static Node detectLoop(Node head) {
        Map<Node, Boolean> seen = new IdentityHashMap<>();
        while (head != null) {
            if (seen.containsKey(head)) {
                return head;
            }
            seen.put(head, null);
            head = head.next;
        }
        return null;
    }
}
