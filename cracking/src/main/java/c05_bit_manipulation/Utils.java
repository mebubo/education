package c05_bit_manipulation;

public class Utils {
    static int countOnes(int n) {
        return countOnes(n, 32 - 1);
    }

    static int countOnes(int n, int limit) {
        int result = 0;
        for (int i = 0; i < limit; i++) {
            if (isBitSet(n, i)) {
                result++;
            }
        }
        return result;
    }

    static int unsetBit(int n, int i) {
        return n & ~(1 << i);
    }

    static int setBit(int n, int i) {
        return n | (1 << i);
    }

    static boolean isBitSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }
}
