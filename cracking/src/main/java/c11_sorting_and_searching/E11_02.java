package c11_sorting_and_searching;

import java.util.Arrays;
import java.util.Comparator;

public class E11_02 {

    public static void sortAnagramsTogether(String[] input) {
        //Arrays.sort(input, Comparator.comparing((String s) -> sorted(s)));
        Arrays.sort(input, sortedStringComparator);
    }

    private static String sorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    private static Comparator<String> sortedStringComparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return sorted(o1).compareTo(sorted(o2));
        }
    };
}
