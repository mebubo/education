package c05_bit_manipulation;

public class E05_06 {
    public static int swapOddAndEvenBits(int n) {
        int mask = createMask2();
        return ((n & mask) << 1) | ((n & ~mask) >> 1);
    }

    private static int createMask() {
        int mask = 0;
        for (int i = 0; i < 32; i += 2) {
            mask |= 1 << i;
        }
        return mask;
    }

    private static int createMask2() {
        return 0x55555555;
    }
}
