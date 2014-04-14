package c01_arrays_and_strings;

public class Duplicates {
    public static void removeDuplicateChars(char[] string) {
        if (string == null) {
            return;
        }
        if (string.length < 2) {
            return ;
        }
        int tail = 1;
        for (int i = 1; i < string.length; i++) {
            int j;
            for (j = 0; j < tail; j++) {
                if (string[i] == string[j]) {
                    break;
                }
            }
            if (j == tail) {
                string[tail] = string[i];
                tail++;
            }
        }
        if (tail < string.length) {
            string[tail] = 0;
        }
    }
    public static String removeDuplicateChars(String string) {
        char[] chars = string.toCharArray();
        removeDuplicateChars(chars);
        int end = 0;
        while (end < chars.length && chars[end] != 0) {
            end++;
        }
        return new String(chars, 0, end);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateChars("fooooo"));
    }
}
