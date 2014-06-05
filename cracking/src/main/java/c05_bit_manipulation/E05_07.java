package c05_bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class E05_07 {

    public static class BitInteger {
        private int x;

        public BitInteger(int x) {
            this.x = x;
        }

        public int fetch(int index) {
            return (x & (1 << index)) == 0 ? 0 : 1;
        }

        public static BitInteger create(int x) {
            return new BitInteger(x);
        }
    }

    public static int findMissing(List<BitInteger> array) {
        return findMissing(array, 0);
    }

    private static int findMissing(List<BitInteger> array, int i) {
        if (i > 31) {
            return 0;
        }
        ArrayList<BitInteger> b0 = new ArrayList<>();
        ArrayList<BitInteger> b1 = new ArrayList<>();
        for (BitInteger x : array) {
            if (x.fetch(i) == 0) {
                b0.add(x);
            } else {
                b1.add(x);
            }
        }
        if (b0.size() <= b1.size()) {
            return (findMissing(b0, i + 1) << 1) | 0;
        } else {
            return (findMissing(b1, i + 1) << 1) | 1;
        }
    }
}
