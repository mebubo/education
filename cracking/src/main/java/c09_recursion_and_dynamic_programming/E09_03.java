package c09_recursion_and_dynamic_programming;

public class E09_03 {

    public static int magicIndex(int[] input) {
        return magicIndexHelper(input, 0, input.length);
    }

    private static int magicIndexHelper(int[] input, int a, int b) {
        if (b <= a || a < 0 || b > input.length) {
            return -1;
        }
        if (b - a == 1) {
            return input[a] == a ? a : -1;
        }
        int mid = (a + b) / 2;
        int midValue = input[mid];
        if (midValue == mid) {
            return mid;
        }
        int midLeft = Math.min(mid, midValue + 1);
        int midRight = Math.max(mid + 1, midValue);
        int result = magicIndexHelper(input, a, midLeft);
        if (result != -1) {
            return result;
        }
        return magicIndexHelper(input, midRight, b);
    }
}
