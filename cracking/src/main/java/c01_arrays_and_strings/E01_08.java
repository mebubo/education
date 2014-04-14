package c01_arrays_and_strings;

public class E01_08 {
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return isSubstring(s1 + s1, s2);
    }

    private static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}
