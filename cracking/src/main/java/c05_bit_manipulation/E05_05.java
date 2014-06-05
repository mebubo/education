package c05_bit_manipulation;

import static c05_bit_manipulation.Utils.countOnes;

public class E05_05 {
    public static int bitSwapsRequired(int n, int m) {
        return countOnes(n ^ m);
    }
}
