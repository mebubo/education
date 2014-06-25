package c11_sorting_and_searching;

public class E11_01 {

    public static void merge(int[] a, int[] b, int aLength) {
        int aIndex = aLength - 1;
        int bIndex = b.length - 1;
        int mergeIndex = aLength  + b.length - 1;
        while (mergeIndex >= 0) {
            if ((bIndex >= 0 && aIndex >= 0) && (a[aIndex] < b[bIndex]) || aIndex < 0) {
                a[mergeIndex--] = b[bIndex--];
            } else {
                a[mergeIndex--] = a[aIndex--];
            }
        }
    }
}
