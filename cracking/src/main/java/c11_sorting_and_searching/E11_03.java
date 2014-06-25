package c11_sorting_and_searching;

public class E11_03 {

    public static int searchInRotated(int[] input, int x) {
        return searchInRotatedHelper(input, x, 0, input.length - 1);
    }

    private static int searchInRotatedHelper(int[] input, int x, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (input[mid] == x) {
            return mid;
        }
        if ((input[mid] < x && x <= input[high]) || (input[mid] > input[high] && x > input[mid] || x < input[high])) {
            return searchInRotatedHelper(input, x, mid + 1, high);
        }
        if ((input[0] <= x && x < input[mid]) || (input[0] > input[mid] && x < input[0] || x > input[mid])) {
            return searchInRotatedHelper(input, x, 0, mid - 1);
        }
        return -1;
    }
}
