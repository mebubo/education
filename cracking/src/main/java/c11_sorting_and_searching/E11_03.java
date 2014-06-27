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
        if ((input[low] <= x && x < input[mid]) || (input[mid] < input[high] && (x < input[mid] || x > input[high]))) {
            return searchInRotatedHelper(input, x, low, mid - 1);
        }
        if ((input[mid] < x && x <= input[high]) || (input[low] < input[mid] && (x < input[low] || x > input[mid]))) {
            return searchInRotatedHelper(input, x, mid + 1, high);
        }
        int result = searchInRotatedHelper(input, x, low, mid - 1);
        return result != -1 ? result : searchInRotatedHelper(input, x, mid + 1, high);
    }
}
