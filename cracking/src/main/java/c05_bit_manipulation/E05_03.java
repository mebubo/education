package c05_bit_manipulation;

public class E05_03 {
    public static int nextSmallestWithTheSameOnesCount(int n) {
        int i;
        boolean found = false;
        for (i = 0; i < 32 - 2; i++) {
            if (Utils.isBitSet(n, i) && !Utils.isBitSet(n, i + 1)) {
                n = Utils.setBit(n, i + 1);
                found = true;
                break;
            }
        }
        if (!found) {
            return n;
        }
        int onesCount = Utils.countOnes(n, i + 1);
        n = clearUpTo(n, i + 1);
        return setUpTo(n, onesCount - 1);
    }

    private static int setUpTo(int n, int i) {
        return i==0 ? n : n | (1 << i - 1);
    }

    private static int clearUpTo(int n, int i) {
        return n & ~((1 << i) - 1);
    }

    // misunderstood the problem
    public static int nextLargestWithTheSameOnesCount(int n) {
        int onesCount = Utils.countOnes(n);
        return ((1 << onesCount) - 1) << 31 - onesCount;
    }

}
