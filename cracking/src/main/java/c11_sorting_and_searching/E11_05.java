package c11_sorting_and_searching;

public class E11_05 {

    public static int binarySearchInArrayWithPossibleEmptyStrings(String[] input, String s) {
        return helper(input, s, 0, input.length - 1);
    }

    private static int helper(String[] input, String s, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        int midLow = skipDown(input, mid, low);
        int midHigh = skipUp(input, mid, high);
        if (input[midLow].equals(s)) {
            return midLow;
        }
        if (input[midHigh].equals(s)) {
            return midHigh;
        }
        if (s.compareTo(input[midLow]) <= 0) {
            return helper(input, s, low, midLow - 1);
        }
        if (s.compareTo(input[midHigh]) >= 0) {
            return helper(input, s, midHigh + 1, high);
        }
        return -1;
    }

    private static int skipUp(String[] input, int i, int max) {
        while (i < max && input[i].isEmpty()) {
            i++;
        }
        return i;
    }

    private static int skipDown(String[] input, int i, int min) {
        while (i > min && input[i].isEmpty()) {
            i--;
        }
        return i;
    }
}
