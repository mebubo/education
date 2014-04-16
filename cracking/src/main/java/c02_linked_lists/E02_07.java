package c02_linked_lists;

public class E02_07 {
    public static boolean isPalindrome(Node l) {
        return l.equals(Node.reverse(Node.copy(l)));
    }
}
